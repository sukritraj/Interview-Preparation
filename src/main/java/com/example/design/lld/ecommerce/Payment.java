package com.example.design.lld.ecommerce;

public class Payment {
    private int paymentId;
    private Order order;
    private PaymentStatus status;

    public Payment(int paymentId, Order order) {
        this.paymentId = paymentId;
        this.order = order;
        this.status = PaymentStatus.PENDING;
    }

    public void makePayment() {
        // Simulating payment success
        this.status = PaymentStatus.COMPLETED;
        System.out.println("Payment Successful for Order ID: " + order);
    }

    public PaymentStatus getStatus() {
        return status;
    }
}

