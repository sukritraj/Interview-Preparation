package com.example.lld.dataBase.factory;

import com.example.lld.dataBase.model.Column;
import com.example.lld.dataBase.model.DataType;
import com.example.lld.dataBase.model.TableSchema;

public final class EntityFactory {
    private EntityFactory() {
    }

    public static Column column(String name, DataType type, boolean required) {
        Column.Builder b = new Column.Builder(name).type(type).required(required);
        if (type == DataType.STRING) b.maxLength(20);
        else b.intRange(-1024, 1024);
        return b.build();
    }

    public static TableSchema schema(Column... cols) {
        var b = new TableSchema.Builder();
        for (var c : cols) b.add(c);
        return b.build();
    }
}
