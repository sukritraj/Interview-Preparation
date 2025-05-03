package com.example.lld.parkingSystem.service;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment of $" + amount + " made using Credit Card.");
        return true;
    }
}
