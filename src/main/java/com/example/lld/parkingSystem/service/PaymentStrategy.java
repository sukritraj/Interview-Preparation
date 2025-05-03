package com.example.lld.parkingSystem.service;

public interface PaymentStrategy {
    boolean processPayment(double amount);
}
