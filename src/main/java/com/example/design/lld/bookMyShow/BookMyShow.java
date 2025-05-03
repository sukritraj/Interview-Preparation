package com.example.design.lld.bookMyShow;

import java.util.Arrays;

public class BookMyShow {
    public static void main(String[] args) {
        Movie movie = new Movie(1, "Inception", "Action", "English");
        CinemaHall hall = new CinemaHall(1, "PVR Cinemas", 100);
        MovieShow show = new MovieShow(1, movie, hall, "10:00 AM", "1:00 PM", 100);

        User user = new User(1, "John Doe", "john.doe@example.com");

        BookingService bookingService = new BookingService();
        boolean isBookingSuccessful = bookingService.bookSeats(show, user, Arrays.asList(1, 2, 3));

        if (isBookingSuccessful) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Booking failed!");
        }
    }
}
