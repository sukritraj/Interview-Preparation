package com.example.lld.parkingLot;

import com.example.lld.parkingLot.entity.ParkingSpot;
import com.example.lld.parkingLot.entity.ParkingTicket;
import com.example.lld.parkingLot.entity.Vehicle;
import com.example.lld.parkingLot.enums.SpotType;
import com.example.lld.parkingLot.enums.VehicleType;
import com.example.lld.parkingLot.service.ParkingLot;

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Central Parking");

        // Adding Parking Spots
        parkingLot.addSpot(new ParkingSpot("B1", SpotType.BIKE));
        parkingLot.addSpot(new ParkingSpot("C1", SpotType.CAR));
        parkingLot.addSpot(new ParkingSpot("C2", SpotType.CAR));
        parkingLot.addSpot(new ParkingSpot("T1", SpotType.TRUCK));

        // Parking a Vehicle
        Vehicle car = new Vehicle("ABC-1234", VehicleType.CAR);
        ParkingTicket ticket = parkingLot.parkVehicle(car);
        System.out.println("Parked at spot: " + ticket.getSpot().getSpotId());

        // Display Available Spots
        System.out.println("Available spots: " + parkingLot.getAvailableSpots());

        // Unparking the Vehicle
        double fee = parkingLot.unparkVehicle(ticket.getTicketId());
        System.out.println("Unparked. Fee: $" + fee);

        // Display Available Spots Again
        System.out.println("Available spots: " + parkingLot.getAvailableSpots());
    }
}
