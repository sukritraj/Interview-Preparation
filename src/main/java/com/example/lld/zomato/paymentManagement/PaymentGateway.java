package com.example.lld.zomato.paymentManagement;

public interface PaymentGateway {
    boolean processPayment(double amount);
}
