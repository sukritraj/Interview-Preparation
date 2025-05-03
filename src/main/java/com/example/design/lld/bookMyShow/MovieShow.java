package com.example.design.lld.bookMyShow;

import java.util.HashMap;
import java.util.Map;

public class MovieShow {
    private int showId;
    private Movie movie;
    private CinemaHall hall;
    private String startTime;
    private String endTime;
    private Map<Integer, SeatStatus> seats;

    public MovieShow(int showId, Movie movie, CinemaHall hall, String startTime, String endTime, int totalSeats) {
        this.showId = showId;
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.endTime = endTime;
        seats = new HashMap<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.put(i, SeatStatus.AVAILABLE);
        }
    }

    public int getAvailableSeats() {
        int availableSeats = 0;
        for (SeatStatus status : seats.values()) {
            if (status == SeatStatus.AVAILABLE) {
                availableSeats++;
            }
        }
        return availableSeats;
    }

    public synchronized boolean bookSeat(int seatNumber) {
        if (seats.get(seatNumber) == SeatStatus.AVAILABLE) {
            seats.put(seatNumber, SeatStatus.BOOKED);
            return true;
        }
        return false;
    }

    public synchronized void releaseSeat(int seatNumber) {
        seats.put(seatNumber, SeatStatus.AVAILABLE);
    }

    public String getShowTime() {
        return startTime + " to " + endTime;
    }
}

