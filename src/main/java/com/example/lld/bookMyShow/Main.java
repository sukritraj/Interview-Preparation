package com.example.lld.bookMyShow;

import com.example.lld.bookMyShow.model.*;
import com.example.lld.bookMyShow.service.BookingService;
import com.example.lld.bookMyShow.service.MovieService;
import com.example.lld.bookMyShow.service.TheatreService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create some movies
        Movie movie1 = new Movie("Avengers", "Action", 150);
        Movie movie2 = new Movie("Inception", "Sci-Fi", 120);

        // Create cities
        City city = new City("Mumbai");

        // Create a theatre
        Theatre theatre = new Theatre("PVR Cinemas", city, Arrays.asList(new Screen("Screen 1", 100)));

        // Add movies to theatre and user
        TheatreService theatreService = new TheatreService();
        theatreService.addTheatre(theatre);

        MovieService movieService = new MovieService();
        movieService.addMovie(movie1);
        movieService.addMovie(movie2);

        // Create user
        User user = new User("John Doe", "john@example.com");

        // Book tickets
        Seat seat = new Seat("A1");
        Show show = new Show(movie1, "10:00 AM", Arrays.asList(seat));
        BookingService bookingService = new BookingService();

        bookingService.bookTicket(user, show, seat);
        bookingService.cancelTicket(user, show, seat);
    }
}

