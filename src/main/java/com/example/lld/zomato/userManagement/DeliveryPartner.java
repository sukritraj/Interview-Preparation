package com.example.lld.zomato.userManagement;

public class DeliveryPartner extends User {
    public String vehicleNumber;
    public boolean isAvailable;

    public DeliveryPartner(String userId, String name, String email, String phone, String address, String vehicleNumber, boolean isAvailable) {
        super(userId, name, email, phone, address);
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = isAvailable;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
