package com.example.lld.bookMyShow.entity;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final User user;
    private final Show show;
    private final List<Seat> bookedSeats;
    private final Payment payment;

    public Booking(String bookingId, User user, Show show, List<Seat> bookedSeats, Payment payment) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.payment = payment;
    }

    public String getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public Show getShow() { return show; }
    public List<Seat> getBookedSeats() { return bookedSeats; }
    public Payment getPayment() { return payment; }
}
