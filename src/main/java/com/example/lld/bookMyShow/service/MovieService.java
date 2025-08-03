package com.example.lld.bookMyShow.service;

import com.example.lld.bookMyShow.model.Movie;
import com.example.lld.bookMyShow.repository.MovieRepository;

public class MovieService {
    private MovieRepository movieRepository = new MovieRepository();

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public Movie getMovie(String name) {
        return movieRepository.getMovie(name);
    }
}
