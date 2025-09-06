package com.example.lld.dataBase.index;

import java.util.Set;

public interface IndexStrategy {
    void add(Object key, int rowId);
    void remove(Object key, int rowId);
    Set<Integer> find(Object key);
    void clear();
}
