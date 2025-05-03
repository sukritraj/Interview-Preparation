package com.example.lld.zomato.paymentManagement;

public class Payment {
    private String paymentId;
    private double amount;
    private PaymentStatus status;
    private String paymentType;

    public Payment(String paymentId, double amount, String paymentType) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.status = PaymentStatus.PENDING;
    }

    public boolean processPayment() {
        PaymentGateway paymentGateway = PaymentFactory.getPaymentGateway(paymentType);
        boolean success = paymentGateway.processPayment(amount);
        this.status = success ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
        return success;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
