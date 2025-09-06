package com.example.lld.dataBase.repository;

import com.example.lld.dataBase.model.Column;
import com.example.lld.dataBase.model.TableSchema;

import java.util.List;
import java.util.Map;

public interface TableRepository {
    int insert(Map<String, Object> values);

    int update(Map<String, Object> filter, Map<String, Object> updates);

    int delete(Map<String, Object> filter);

    int truncate();

    List<Map<String, Object>> select(Map<String, Object> filter);

    void printAll();

    TableSchema schema();

    void addColumn(Column c, Object defaultValue);

    void dropColumn(String column);

    void createIndex(String idxName, String column);

    void dropIndex(String idxName);

    void rebuildIndex(String idxName);
}
