package com.example.design.lld.bookMyShow;

import java.util.List;

public class Movie {
    private int movieId;
    private String name;
    private String genre;
    private String language;
    private List<CinemaHall> availableCinemas;

    public Movie(int movieId, String name, String genre, String language) {
        this.movieId = movieId;
        this.name = name;
        this.genre = genre;
        this.language = language;
    }

    public List<CinemaHall> getAvailableCinemas() {
        return availableCinemas;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }
}

