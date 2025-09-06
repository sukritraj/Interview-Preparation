package com.example.lld.dataBase.index;

public final class Index {
    private final String name;
    private final String column;
    private final IndexStrategy strategy;

    public Index(String name, String column, IndexStrategy strat) {
        this.name = name;
        this.column = column;
        this.strategy = strat;
    }

    public String column() {
        return column;
    }

    public void add(Object k, int id) {
        strategy.add(k, id);
    }

    public void remove(Object k, int id) {
        strategy.remove(k, id);
    }

    public java.util.Set<Integer> find(Object k) {
        return strategy.find(k);
    }

    public void clear() {
        strategy.clear();
    }
}