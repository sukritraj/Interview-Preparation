package com.example.lld.parkingLot.entity;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot spot, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
    }

    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }

    public Duration getParkingDuration() {
        return Duration.between(entryTime, exitTime);
    }

    public String getTicketId() { return ticketId; }
    public ParkingSpot getSpot() { return spot; }
    public Vehicle getVehicle() { return vehicle; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
}
