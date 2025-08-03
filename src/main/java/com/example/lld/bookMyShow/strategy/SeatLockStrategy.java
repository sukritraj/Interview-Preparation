package com.example.lld.bookMyShow.strategy;

import com.example.lld.bookMyShow.model.Seat;

public class SeatLockStrategy {
    public boolean lockSeat(Seat seat) {
        if (!seat.isBooked()) {
            seat.bookSeat();
            return true;
        }
        return false;
    }

    public void unlockSeat(Seat seat) {
        seat.cancelSeat();
    }
}

