package com.example.lld.bookMyShow.service;

import com.example.lld.bookMyShow.model.Theatre;
import com.example.lld.bookMyShow.repository.TheatreRepository;

public class TheatreService {
    private TheatreRepository theatreRepository = new TheatreRepository();

    public void addTheatre(Theatre theatre) {
        theatreRepository.addTheatre(theatre);
    }

    public Theatre getTheatre(String name) {
        return theatreRepository.getTheatre(name);
    }
}
