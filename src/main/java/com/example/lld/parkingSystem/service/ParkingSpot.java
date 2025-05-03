package com.example.lld.parkingSystem.service;


import com.example.lld.parkingSystem.entity.Vehicle;

public class ParkingSpot {
    private String id;
    private boolean isReserved;
    private Vehicle vehicle;
    private boolean isAvailable;

    public ParkingSpot(String id, boolean isReserved) {
        this.id = id;
        this.isReserved = isReserved;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void assignVehicle(Vehicle vehicle) {
        if (isAvailable) {
            this.vehicle = vehicle;
            this.isAvailable = false;
        }
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public String getId() {
        return id;
    }
}

