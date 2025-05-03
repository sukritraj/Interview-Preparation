package com.example.design.lld.bookMyShow;

import java.util.List;

public class BookingService {
    public boolean bookSeats(MovieShow show, User user, List<Integer> seatNumbers) {
        synchronized (show) {
            for (int seat : seatNumbers) {
                if (!show.bookSeat(seat)) {
                    return false; // If any seat is unavailable, booking fails
                }
            }
        }

        // Process payment
        Payment payment = new Payment(1000); // Amount can be dynamic
        if (payment.processPayment()) {
            // Payment successful, generate ticket
            Ticket ticket = new Ticket(1, user, show, seatNumbers, 1000);
            user.bookTicket(show, seatNumbers);
            return true;
        } else {
            // If payment fails, release seats
            for (int seat : seatNumbers) {
                show.releaseSeat(seat);
            }
            return false;
        }
    }

    public boolean cancelBooking(Ticket ticket) {
        // Cancel the ticket and refund process
        ticket.cancelTicket();
        return true;
    }
}
