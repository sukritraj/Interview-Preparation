package com.example.lld.zomato.paymentManagement;

public class CreditCardPayment implements PaymentGateway{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of: " + amount);
        return true;
    }
}
