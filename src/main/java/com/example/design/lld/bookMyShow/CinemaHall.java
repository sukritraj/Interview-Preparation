package com.example.design.lld.bookMyShow;

import java.util.List;

public class CinemaHall {
    private int hallId;
    private String hallName;
    private List<MovieShow> shows;
    private int totalSeats;

    public CinemaHall(int hallId, String hallName, int totalSeats) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.totalSeats = totalSeats;
    }

    public List<MovieShow> getMovieShows() {
        return shows;
    }

    public int getAvailableSeats(MovieShow show) {
        return show.getAvailableSeats();
    }

    public String getHallName() {
        return hallName;
    }
}

