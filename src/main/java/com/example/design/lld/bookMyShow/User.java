package com.example.design.lld.bookMyShow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String email;
    private List<Ticket> bookingHistory;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.bookingHistory = new ArrayList<>();
    }

    public void bookTicket(MovieShow show, List<Integer> seatNumbers) {
        // Logic to book a ticket and add to booking history
    }

    public List<Ticket> getBookingHistory() {
        return bookingHistory;
    }
}

