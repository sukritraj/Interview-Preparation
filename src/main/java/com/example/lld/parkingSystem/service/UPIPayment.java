package com.example.lld.parkingSystem.service;

public class UPIPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of $" + amount + " made using UPI.");
        return true;
    }
}
