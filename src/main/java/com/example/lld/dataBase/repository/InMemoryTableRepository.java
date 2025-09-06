package com.example.lld.dataBase.repository;

import com.example.lld.dataBase.exception.IndexException;
import com.example.lld.dataBase.exception.SchemaException;
import com.example.lld.dataBase.index.HashIndexStrategy;
import com.example.lld.dataBase.index.Index;
import com.example.lld.dataBase.model.Column;
import com.example.lld.dataBase.model.TableSchema;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryTableRepository implements TableRepository {
    private final String name;
    private TableSchema schema;
    private final Map<Integer, LinkedHashMap<String, Object>> rows = new LinkedHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(1);
    private final Map<String, Index> indexes = new LinkedHashMap<>();

    public InMemoryTableRepository(String name, TableSchema schema) {
        this.name = name;
        this.schema = schema;
    }

    @Override
    public TableSchema schema() {
        return schema;
    }

    @Override
    public int insert(Map<String, Object> values) {
        ensureKnown(values.keySet());
        LinkedHashMap<String, Object> row = new LinkedHashMap<>();
        for (String c : schema.columnNames()) row.put(c, null);
        values.forEach(row::put);
        for (Column c : schema.columns()) c.validateValue(row.get(c.name()));
        int id = seq.getAndIncrement();
        rows.put(id, row);
        for (Index idx : indexes.values()) idx.add(row.get(idx.column()), id);
        return id;
    }

    @Override
    public int update(Map<String, Object> filter, Map<String, Object> updates) {
        ensureKnown(updates.keySet());
        updates.forEach((k, v) -> schema.get(k).orElseThrow(() -> new SchemaException("Unknown col: " + k)).validateValue(v));
        Set<Integer> ids = matchFilter(filter);
        int c = 0;
        for (int id : ids) {
            var row = rows.get(id);
            for (var e : updates.entrySet()) {
                Object old = row.get(e.getKey());
                Object neu = e.getValue();
                if (!Objects.equals(old, neu)) {
                    for (Index idx : indexes.values())
                        if (idx.column().equals(e.getKey())) {
                            idx.remove(old, id);
                            idx.add(neu, id);
                        }
                    row.put(e.getKey(), neu);
                }
            }
            c++;
        }
        return c;
    }

    @Override
    public int delete(Map<String, Object> filter) {
        Set<Integer> ids = matchFilter(filter);
        int c = 0;
        for (int id : ids) {
            var row = rows.remove(id);
            if (row != null) {
                indexes.values().forEach(idx -> idx.remove(row.get(idx.column()), id));
                c++;
            }
        }
        return c;
    }

    @Override
    public int truncate() {
        int s = rows.size();
        rows.clear();
        indexes.values().forEach(Index::clear);
        return s;
    }

    @Override
    public List<Map<String, Object>> select(Map<String, Object> filter) {
        Set<Integer> ids = matchFilter(filter);
        List<Map<String, Object>> out = new ArrayList<>();
        for (int id : ids) {
            var r = rows.get(id);
            if (r != null) {
                LinkedHashMap<String, Object> c = new LinkedHashMap<>();
                c.put("_rowId", id);
                schema.columnNames().forEach(col -> c.put(col, r.get(col)));
                out.add(c);
            }
        }
        return out;
    }

    @Override
    public void printAll() {
        System.out.println("Table: " + name + " rows=" + rows.size());
        var cols = new ArrayList<>(schema.columnNames());
        System.out.printf("%-7s", "_rowId");
        cols.forEach(c -> System.out.printf(" | %-15s", c));
        System.out.println();
        rows.forEach((id, row) -> {
            System.out.printf("%-7d", id);
            cols.forEach(col -> System.out.printf(" | %-15s", row.get(col)));
            System.out.println();
        });
    }

    @Override
    public void addColumn(Column c, Object defaultValue) {
        if (schema.columnNames().contains(c.name())) throw new SchemaException("Column exists: " + c.name());
        c.validateValue(defaultValue);
        var b = new TableSchema.Builder();
        schema.columns().forEach(b::add);
        b.add(c);
        schema = b.build();
        rows.values().forEach(r -> r.put(c.name(), defaultValue));
    }

    @Override
    public void dropColumn(String column) {
        if (!schema.columnNames().contains(column)) throw new SchemaException("Column not found: " + column);
        indexes.values().removeIf(idx -> idx.column().equals(column));
        var b = new TableSchema.Builder();
        schema.columns().forEach(col -> {
            if (!col.name().equals(column)) b.add(col);
        });
        schema = b.build();
        rows.values().forEach(r -> r.remove(column));
    }

    @Override
    public void createIndex(String idxName, String column) {
        if (!schema.columnNames().contains(column)) throw new IndexException("Unknown col for index: " + column);
        if (indexes.containsKey(idxName)) throw new IndexException("Index exists: " + idxName);
        Index idx = new Index(idxName, column, new HashIndexStrategy());
        rows.forEach((id, row) -> idx.add(row.get(column), id));
        indexes.put(idxName, idx);
    }

    @Override
    public void dropIndex(String idxName) {
        if (indexes.remove(idxName) == null) throw new IndexException("Index not found: " + idxName);
    }

    @Override
    public void rebuildIndex(String idxName) {
        Index idx = indexes.get(idxName);
        if (idx == null) throw new IndexException("Index not found: " + idxName);
        idx.clear();
        rows.forEach((id, row) -> idx.add(row.get(idx.column()), id));
    }

    private void ensureKnown(Set<String> keys) {
        for (String k : keys) if (!schema.columnNames().contains(k)) throw new SchemaException("Unknown column: " + k);
    }

    // matchFilter uses varFiltersCg as required
    private Set<Integer> matchFilter(Map<String, Object> filter) {
        Map<String, Object> varFiltersCg = (filter == null) ? Map.of() : filter;
        if (varFiltersCg.isEmpty()) return new LinkedHashSet<>(rows.keySet());
        if (varFiltersCg.size() == 1) {
            var e = varFiltersCg.entrySet().iterator().next();
            String col = e.getKey();
            Object val = e.getValue();
            for (Index idx : indexes.values()) if (idx.column().equals(col)) return new LinkedHashSet<>(idx.find(val));
        }
        Set<Integer> res = new LinkedHashSet<>();
        outer:
        for (var entry : rows.entrySet()) {
            var row = entry.getValue();
            for (var fv : varFiltersCg.entrySet()) {
                Object expect = fv.getValue();
                Object got = row.get(fv.getKey());
                if (!Objects.equals(expect, got)) continue outer;
            }
            res.add(entry.getKey());
        }
        return res;
    }
}