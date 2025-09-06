package com.example.lld.dataBase.model;

import com.example.lld.dataBase.exception.SchemaException;

import java.util.Objects;

public final class Column {
    private final String name;
    private final DataType type;
    private final boolean required;
    private final Integer maxLength; // for STRING
    private final Integer minInt, maxInt; // for INT

    private Column(Builder b){
        this.name = Objects.requireNonNull(b.name);
        this.type = Objects.requireNonNull(b.type);
        this.required = b.required;
        this.maxLength = b.maxLength;
        this.minInt = b.minInt; this.maxInt = b.maxInt;
        validateDefinition();
    }

    public String name(){ return name; }
    public DataType type(){ return type; }
    public boolean required(){ return required; }

    public void validateValue(Object value){
        if (value == null) { if (required) throw new SchemaException("Column '"+name+"' is required"); return; }
        switch(type){
            case STRING -> {
                if (!(value instanceof String)) throw new SchemaException(name + " expects STRING");
                if (((String)value).length() > maxLength) throw new SchemaException(name + " max length " + maxLength);
            }
            case INT -> {
                Integer i = coerceToInt(value);
                if (i < minInt || i > maxInt) throw new SchemaException(name + " int range ["+minInt+","+maxInt+"]");
            }
        }
    }

    private Integer coerceToInt(Object v){
        if (v instanceof Integer) return (Integer)v;
        if (v instanceof Number) return ((Number)v).intValue();
        if (v instanceof String) try { return Integer.parseInt(((String)v).trim()); } catch(Exception e){}
        throw new SchemaException(name + " cannot coerce to int");
    }

    private void validateDefinition(){
        if (type == DataType.STRING) {
            if (maxLength == null || maxLength < 1 || maxLength > 20) throw new SchemaException("STRING maxLength must be 1..20");
        } else {
            if (minInt == null || maxInt == null || minInt < -1024 || maxInt > 1024 || minInt > maxInt) throw new SchemaException("INT range invalid");
        }
    }

    public static class Builder{
        private final String name; private DataType type; private boolean required=false;
        private Integer maxLength=null; private Integer minInt=null, maxInt=null;
        public Builder(String name){ this.name = name; }
        public Builder type(DataType t){ this.type = t; return this; }
        public Builder required(boolean r){ this.required = r; return this; }
        public Builder maxLength(int m){ this.maxLength = m; return this; }
        public Builder intRange(int min, int max){ this.minInt = min; this.maxInt = max; return this; }
        public Column build(){ return new Column(this); }
    }
}
