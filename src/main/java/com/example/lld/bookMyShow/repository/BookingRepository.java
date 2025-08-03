package com.example.lld.bookMyShow.repository;

import com.example.lld.bookMyShow.model.Seat;
import com.example.lld.bookMyShow.model.Show;
import com.example.lld.bookMyShow.model.User;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private Map<String, Seat> bookedSeats = new HashMap<>();

    public void bookSeat(User user, Show show, Seat seat) {
        String bookingKey = user.getEmail() + "-" + show.getMovie().getName() + "-" + seat.getSeatNumber();
        bookedSeats.put(bookingKey, seat);
        seat.bookSeat();
    }

    public void cancelBooking(User user, Show show, Seat seat) {
        String bookingKey = user.getEmail() + "-" + show.getMovie().getName() + "-" + seat.getSeatNumber();
        bookedSeats.remove(bookingKey);
        seat.cancelSeat();
    }
}

