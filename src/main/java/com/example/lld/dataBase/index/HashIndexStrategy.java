package com.example.lld.dataBase.index;

import java.util.*;

public final class HashIndexStrategy implements IndexStrategy {
    private final Map<Object, LinkedHashSet<Integer>> map = new HashMap<>();

    @Override
    public void add(Object key, int rowId) {
        if (key == null) return;
        map.computeIfAbsent(key, k -> new LinkedHashSet<>()).add(rowId);
    }

    @Override
    public void remove(Object key, int rowId) {
        if (key == null) return;
        var s = map.get(key);
        if (s != null) {
            s.remove(rowId);
            if (s.isEmpty()) map.remove(key);
        }
    }

    @Override
    public Set<Integer> find(Object key) {
        LinkedHashSet<Integer> bucket = map.get(key);
        if (bucket == null) {
            return Collections.emptySet(); // already a Set<Integer>
        }
        return new LinkedHashSet<>(bucket); // defensive copy
    }

    @Override
    public void clear() {
        map.clear();
    }
}
