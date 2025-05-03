package com.example.lld.parkingLot.entity;

import com.example.lld.parkingLot.enums.PaymentStatus;

public class Payment {
    private final String paymentId;
    private final double amount;
    private PaymentStatus status;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public boolean processPayment() {
        // Simulate payment processing
        this.status = PaymentStatus.SUCCESS;
        return true;
    }

    public PaymentStatus getStatus() { return status; }
    public String getPaymentId() { return paymentId; }
}
