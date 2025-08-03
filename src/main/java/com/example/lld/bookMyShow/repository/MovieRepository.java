package com.example.lld.bookMyShow.repository;

import com.example.lld.bookMyShow.model.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
    private Map<String, Movie> movies = new HashMap<>();

    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public Movie getMovie(String name) {
        return movies.get(name);
    }
}

