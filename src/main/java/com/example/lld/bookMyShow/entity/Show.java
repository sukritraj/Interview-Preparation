package com.example.lld.bookMyShow.entity;

import java.time.LocalDateTime;

public class Show {
    private final String showId;
    private final Movie movie;
    private final Screen screen;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final double price;

    public Show(String showId, Movie movie, Screen screen, LocalDateTime startTime, LocalDateTime endTime, double price) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public String getShowId() { return showId; }
    public Movie getMovie() { return movie; }
    public Screen getScreen() { return screen; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public double getPrice() { return price; }
}
