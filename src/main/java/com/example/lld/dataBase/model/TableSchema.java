package com.example.lld.dataBase.model;

import com.example.lld.dataBase.exception.SchemaException;

import java.util.*;

public final class TableSchema {
    private final LinkedHashMap<String, Column> cols;
    private TableSchema(Builder b){ this.cols = new LinkedHashMap<>(b.cols); }
    public Collection<Column> columns(){ return Collections.unmodifiableCollection(cols.values()); }
    public Optional<Column> get(String name){ return Optional.ofNullable(cols.get(name)); }
    public Set<String> columnNames(){ return Collections.unmodifiableSet(cols.keySet()); }


    public static class Builder{
        private final LinkedHashMap<String, Column> cols = new LinkedHashMap<>();
        public Builder add(Column c){ if (cols.containsKey(c.name())) throw new SchemaException("Duplicate column: " + c.name()); cols.put(c.name(), c); return this; }
        public TableSchema build(){ if (cols.isEmpty()) throw new SchemaException("Schema must have at least one column"); return new TableSchema(this); }
    }
}
