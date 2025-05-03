package com.example.lld.bookMyShow.entity;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String screenId;
    private final String name;
    private final List<Seat> seats;

    public Screen(String screenId, String name) {
        this.screenId = screenId;
        this.name = name;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public String getScreenId() { return screenId; }
    public String getName() { return name; }
    public List<Seat> getSeats() { return seats; }
}
