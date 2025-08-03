package com.example.lld.bookMyShow.repository;


import com.example.lld.bookMyShow.model.Theatre;

import java.util.HashMap;
import java.util.Map;

public class TheatreRepository {
    private Map<String, Theatre> theatres = new HashMap<>();

    public void addTheatre(Theatre theatre) {
        theatres.put(theatre.getName(), theatre);
    }

    public Theatre getTheatre(String name) {
        return theatres.get(name);
    }
}

