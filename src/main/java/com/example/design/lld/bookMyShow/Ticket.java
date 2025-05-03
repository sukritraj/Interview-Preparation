package com.example.design.lld.bookMyShow;

import java.util.List;

public class Ticket {
    private int ticketId;
    private User user;
    private MovieShow show;
    private List<Integer> seatNumbers;
    private float totalPrice;
    private PaymentStatus paymentStatus;

    public Ticket(int ticketId, User user, MovieShow show, List<Integer> seatNumbers, float totalPrice) {
        this.ticketId = ticketId;
        this.user = user;
        this.show = show;
        this.seatNumbers = seatNumbers;
        this.totalPrice = totalPrice;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void cancelTicket() {
        // Logic to cancel ticket and release seats
        for (int seat : seatNumbers) {
            show.releaseSeat(seat);
        }
        paymentStatus = PaymentStatus.FAILED;
    }
}

