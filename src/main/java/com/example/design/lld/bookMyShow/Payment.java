package com.example.design.lld.bookMyShow;

public class Payment {
    private PaymentStatus paymentStatus;
    private float amount;

    public Payment(float amount) {
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public boolean processPayment() {
        // Integrate with payment gateway and return status
        // For simplicity, assuming payment is successful
        paymentStatus = PaymentStatus.COMPLETED;
        return true;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}

