package com.example.lld.bookMyShow.entity;

import com.example.lld.bookMyShow.enums.Genre;

public class Movie {
    private final String movieId;
    private final String title;
    private final Genre genre;
    private final int duration; // in minutes

    public Movie(String movieId, String title, Genre genre, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public Genre getGenre() { return genre; }
    public int getDuration() { return duration; }
}
