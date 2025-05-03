package com.example.lld.zomato.paymentManagement;

public class UPIPayment implements PaymentGateway{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing UPI Payment of: " + amount);
        return true;
    }
}
