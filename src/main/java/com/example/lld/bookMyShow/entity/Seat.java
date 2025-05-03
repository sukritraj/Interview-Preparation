package com.example.lld.bookMyShow.entity;

import com.example.lld.bookMyShow.enums.SeatStatus;

public class Seat {
    private final String seatId;
    private SeatStatus status;

    public Seat(String seatId) {
        this.seatId = seatId;
        this.status = SeatStatus.AVAILABLE;
    }

    public void bookSeat() { this.status = SeatStatus.BOOKED; }
    public void blockSeat() { this.status = SeatStatus.BLOCKED; }
    public void releaseSeat() { this.status = SeatStatus.AVAILABLE; }

    public String getSeatId() { return seatId; }
    public SeatStatus getStatus() { return status; }
}
