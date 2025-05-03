package com.example.lld.parkingSystem.entity;

import com.example.lld.parkingSystem.service.ParkingSpot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private String vehicleNumber;
    private LocalDateTime entryTime;
    private ParkingSpot assignedSpot;

    public Ticket(String vehicleNumber, ParkingSpot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicleNumber = vehicleNumber;
        this.entryTime = LocalDateTime.now();
        this.assignedSpot = spot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getAssignedSpot() {
        return assignedSpot;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
