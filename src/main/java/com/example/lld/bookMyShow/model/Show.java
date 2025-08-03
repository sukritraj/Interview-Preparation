package com.example.lld.bookMyShow.model;

import java.util.List;

public class Show {
    private Movie movie;
    private String time;
    private List<Seat> seats;

    public Show(Movie movie, String time, List<Seat> seats) {
        this.movie = movie;
        this.time = time;
        this.seats = seats;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

