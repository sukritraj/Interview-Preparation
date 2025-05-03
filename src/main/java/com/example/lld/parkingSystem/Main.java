package com.example.lld.parkingSystem;

import com.example.lld.parkingSystem.entity.*;
import com.example.lld.parkingSystem.service.ParkingLot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        // Add parking spots
        parkingLot.addParkingSpot("P1", false);
        parkingLot.addParkingSpot("P2", true);
        parkingLot.addParkingSpot("P3", false);

        Vehicle car1 = new Car("KA-01-HH-1234");
        Vehicle bike1 = new Bike("KA-01-HH-5678");
        Vehicle truck1 = new Truck("KA-01-HH-9101");

        Ticket carTicket = parkingLot.parkVehicle(car1);
        Ticket bikeTicket = parkingLot.parkVehicle(bike1);
        Ticket truckTicket = parkingLot.parkVehicle(truck1);


        if (carTicket != null) {
            System.out.println("🚗 Car parked at: " + carTicket.getAssignedSpot().getId());
        }
        if (bikeTicket != null) {
            System.out.println("🏍️ Bike parked at: " + bikeTicket.getAssignedSpot().getId());
        }
        if (truckTicket != null) {
            System.out.println("🚛 Truck parked at: " + truckTicket.getAssignedSpot().getId());
        }

        // Simulate exit
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter Ticket ID to unpark:");
        String ticketId = scanner.nextLine();

        System.out.println("Select Payment Method (creditcard / upi / cash):");
        String paymentMethod = scanner.nextLine();

        parkingLot.unparkVehicle(ticketId, paymentMethod);
    }
}

