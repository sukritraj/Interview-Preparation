package com.example.lld.parkingLot.entity;

import com.example.lld.parkingLot.enums.SpotType;

public class ParkingSpot {
    private final String spotId;
    private final SpotType type;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType type) {
        this.spotId = spotId;
        this.type = type;
        this.isOccupied = false;
    }

    public boolean isAvailable() { return !isOccupied; }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public String getSpotId() { return spotId; }
    public SpotType getType() { return type; }
}
