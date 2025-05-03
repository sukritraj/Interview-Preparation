package com.example.lld.parkingSystem.entity;

public abstract class Vehicle {
    private String numberPlate;

    public Vehicle(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }
}
