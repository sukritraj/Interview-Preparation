package com.example.lld.bookMyShow.service;

import com.example.lld.bookMyShow.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    private static BookingService instance;
    private final Map<String, Booking> bookings;

    private BookingService() {
        bookings = new HashMap<>();
    }

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }

    public Booking createBooking(User user, Show show, List<Seat> seats) {
        seats.forEach(Seat::bookSeat);
        Payment payment = new Payment(UUID.randomUUID().toString(), show.getPrice() * seats.size());
        payment.processPayment();
        Booking booking = new Booking(UUID.randomUUID().toString(), user, show, seats, payment);
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }
}
