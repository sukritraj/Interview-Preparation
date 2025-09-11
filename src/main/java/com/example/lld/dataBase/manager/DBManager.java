package com.example.lld.dataBase.manager;

import com.example.lld.dataBase.model.TableSchema;
import com.example.lld.dataBase.repository.InMemoryTableRepository;
import com.example.lld.dataBase.repository.TableRepository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class DBManager {
    private static final DBManager INSTANCE = new DBManager();
    private final Map<String, Map<String, TableRepository>> store = new LinkedHashMap<>();

    private DBManager() {
    }

    public static DBManager getInstance() {
        return INSTANCE;
    }

    public void createDatabase(String name) {
        if (store.containsKey(name)) throw new RuntimeException("DB exists");
        store.put(name, new LinkedHashMap<>());
    }

    public void dropDatabase(String name) {
        if (store.remove(name) == null) throw new RuntimeException("DB not found");
    }

    public void createTable(String dbName, String tableName, TableSchema schema) {
        var db = store.get(dbName);
        if (db == null) throw new RuntimeException("DB not found: " + dbName);
        if (db.containsKey(tableName)) throw new RuntimeException("Table exists: " + tableName);
        db.put(tableName, new InMemoryTableRepository(tableName, schema));
    }

    public TableRepository table(String dbName, String tableName) {
        var db = store.get(dbName);
        if (db == null) throw new RuntimeException("DB not found");
        var t = db.get(tableName);
        if (t == null) throw new RuntimeException("Table not found: " + tableName);
        return t;
    }

    public Set<String> listDatabases() {
        return Collections.unmodifiableSet(store.keySet());
    }

    public Set<String> listTables(String dbName) {
        var db = store.get(dbName);
        if (db == null) throw new RuntimeException("DB not found");
        return Collections.unmodifiableSet(db.keySet());
    }
}