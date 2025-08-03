package com.example.lld.bookMyShow.service;


import com.example.lld.bookMyShow.model.Seat;
import com.example.lld.bookMyShow.model.Show;
import com.example.lld.bookMyShow.model.User;
import com.example.lld.bookMyShow.repository.BookingRepository;

public class BookingService {
    private BookingRepository bookingRepository = new BookingRepository();

    public void bookTicket(User user, Show show, Seat seat) {
        if (!seat.isBooked()) {
            bookingRepository.bookSeat(user, show, seat);
            System.out.println("Ticket booked successfully for " + user.getName());
        } else {
            System.out.println("Seat already booked.");
        }
    }

    public void cancelTicket(User user, Show show, Seat seat) {
        if (seat.isBooked()) {
            bookingRepository.cancelBooking(user, show, seat);
            System.out.println("Ticket cancelled successfully for " + user.getName());
        } else {
            System.out.println("No booking found for this seat.");
        }
    }
}