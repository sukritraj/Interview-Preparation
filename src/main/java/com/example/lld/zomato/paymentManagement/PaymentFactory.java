package com.example.lld.zomato.paymentManagement;

public class PaymentFactory {
    public static PaymentGateway getPaymentGateway(String type) {
        switch (type.toLowerCase()) {
            case "creditcard": return new CreditCardPayment();
            case "upi": return new UPIPayment();
            default: throw new IllegalArgumentException("Invalid Payment Type");
        }
    }
}
