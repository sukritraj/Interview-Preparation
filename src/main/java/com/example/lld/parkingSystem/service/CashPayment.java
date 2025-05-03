package com.example.lld.parkingSystem.service;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of $" + amount + " made using Cash.");
        return true;
    }
}
