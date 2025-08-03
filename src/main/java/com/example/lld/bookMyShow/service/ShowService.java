package com.example.lld.bookMyShow.service;


import com.example.lld.bookMyShow.model.Movie;
import com.example.lld.bookMyShow.model.Seat;
import com.example.lld.bookMyShow.model.Show;

import java.util.List;

public class ShowService {
    public Show createShow(Movie movie, String time, List<Seat> seats) {
        return new Show(movie, time, seats);
    }
}
