package com.example.lld.bookMyShow;

import com.example.lld.bookMyShow.entity.*;
import com.example.lld.bookMyShow.enums.Genre;
import com.example.lld.bookMyShow.service.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Main Class for Testing
public class BookMyShowSystem {
    public static void main(String[] args) {
        // Create Movies
        Movie movie1 = new Movie("M1", "Inception", Genre.THRILLER, 148);
        Movie movie2 = new Movie("M2", "Toy Story", Genre.COMEDY, 90);

        // Create Theatres and Screens
        Theatre theatre = new Theatre("T1", "PVR Cinemas", "Downtown");
        Screen screen1 = new Screen("S1", "Screen 1");
        Screen screen2 = new Screen("S2", "Screen 2");

        // Add Seats to Screens
        for (int i = 1; i <= 10; i++) {
            screen1.addSeat(new Seat("S1-SEAT" + i));
            screen2.addSeat(new Seat("S2-SEAT" + i));
        }

        theatre.addScreen(screen1);
        theatre.addScreen(screen2);

        // Create Shows
        Show show1 = new Show("SHOW1", movie1, screen1, LocalDateTime.of(2024, 12, 31, 18, 30),
                LocalDateTime.of(2024, 12, 31, 21, 00), 200.00);
        Show show2 = new Show("SHOW2", movie2, screen2, LocalDateTime.of(2024, 12, 31, 16, 00),
                LocalDateTime.of(2024, 12, 31, 17, 30), 150.00);

        // Booking Service
        BookingService bookingService = BookingService.getInstance();

        // Simulate a User Booking
        User user = new User("U1", "Sukrit Raj", "sukritraj3@gmail.com");

        List<Seat> selectedSeats = new ArrayList<>();
        selectedSeats.add(screen1.getSeats().get(0)); // Seat S1-SEAT1
        selectedSeats.add(screen1.getSeats().get(1)); // Seat S1-SEAT2

        Booking booking = bookingService.createBooking(user, show1, selectedSeats);

        // Print Booking Details
        System.out.println("Booking Details:");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("User: " + booking.getUser().getName());
        System.out.println("Show: " + booking.getShow().getMovie().getTitle());
        System.out.println("Seats: " + booking.getBookedSeats().stream().map(Seat::getSeatId).toList());
        System.out.println("Payment Status: " + booking.getPayment().getStatus());
    }
}

