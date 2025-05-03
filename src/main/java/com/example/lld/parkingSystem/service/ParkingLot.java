package com.example.lld.parkingSystem.service;

import com.example.lld.parkingSystem.entity.Ticket;
import com.example.lld.parkingSystem.entity.*;
import com.example.lld.parkingSystem.factory.PaymentFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot instance;
    private Map<String, Ticket> activeTickets;
    private Map<String, ParkingSpot> parkingSpots;

    private ParkingLot() {
        this.activeTickets = new HashMap<>();
        this.parkingSpots = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addParkingSpot(String id, boolean isReserved) {
        parkingSpots.put(id, new ParkingSpot(id, isReserved));
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.isAvailable()) {
                spot.assignVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle.getNumberPlate(), spot);
                activeTickets.put(ticket.getTicketId(), ticket);
                System.out.println("🚗 Ticket Generated: " + ticket.getTicketId());
                return ticket;
            }
        }
        System.out.println("❌ No available spots!");
        return null;
    }

    public void unparkVehicle(String ticketId, String paymentMethod) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("❌ Invalid Ticket.");
            return;
        }

        ParkingSpot spot = ticket.getAssignedSpot();
        spot.removeVehicle();
        activeTickets.remove(ticketId);

        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        double amount = (hours == 0) ? 10 : hours * 10;

        PaymentStrategy paymentStrategy = PaymentFactory.getPaymentMethod(paymentMethod);
        paymentStrategy.processPayment(amount);

        System.out.println("✅ Vehicle Unparked. Spot Freed.");
    }
}
