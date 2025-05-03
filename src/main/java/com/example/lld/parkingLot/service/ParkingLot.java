package com.example.lld.parkingLot.service;

import com.example.lld.parkingLot.entity.ParkingSpot;
import com.example.lld.parkingLot.entity.ParkingTicket;
import com.example.lld.parkingLot.entity.Vehicle;
import com.example.lld.parkingLot.enums.SpotType;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private final String name;
    private final Map<SpotType, List<ParkingSpot>> spots;
    private final Map<String, ParkingTicket> activeTickets;

    public ParkingLot(String name) {
        this.name = name;
        this.spots = new HashMap<>();
        this.activeTickets = new HashMap<>();
        for (SpotType type : SpotType.values()) {
            spots.put(type, new ArrayList<>());
        }
    }

    public void addSpot(ParkingSpot spot) {
        spots.get(spot.getType()).add(spot);
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        SpotType requiredSpotType = SpotType.valueOf(vehicle.getType().name());
        for (ParkingSpot spot : spots.get(requiredSpotType)) {
            if (spot.isAvailable()) {
                String ticketId = UUID.randomUUID().toString();
                ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, spot, LocalDateTime.now());
                spot.parkVehicle(vehicle);
                activeTickets.put(ticketId, ticket);
                return ticket;
            }
        }
        throw new RuntimeException("No available spots for vehicle type: " + vehicle.getType());
    }

    public double unparkVehicle(String ticketId) {
        if (!activeTickets.containsKey(ticketId)) {
            throw new RuntimeException("Invalid ticket ID: " + ticketId);
        }
        ParkingTicket ticket = activeTickets.remove(ticketId);
        ticket.setExitTime(LocalDateTime.now());
        ParkingSpot spot = ticket.getSpot();
        spot.removeVehicle();
        ParkingFeeCalculator feeCalculator = new ParkingFeeCalculator();
        return feeCalculator.calculateFee(ticket);
    }

    public Map<SpotType, Long> getAvailableSpots() {
        Map<SpotType, Long> availableSpots = new HashMap<>();
        for (Map.Entry<SpotType, List<ParkingSpot>> entry : spots.entrySet()) {
            long count = entry.getValue().stream().filter(ParkingSpot::isAvailable).count();
            availableSpots.put(entry.getKey(), count);
        }
        return availableSpots;
    }
}
