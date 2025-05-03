package com.example.lld.parkingSystem.factory;

import com.example.lld.parkingSystem.service.CashPayment;
import com.example.lld.parkingSystem.service.CreditCardPayment;
import com.example.lld.parkingSystem.service.PaymentStrategy;
import com.example.lld.parkingSystem.service.UPIPayment;

public class PaymentFactory {
    public static PaymentStrategy getPaymentMethod(String method) {
        switch (method.toLowerCase()) {
            case "creditcard": return new CreditCardPayment();
            case "upi": return new UPIPayment();
            case "cash": return new CashPayment();
            default: throw new IllegalArgumentException("Invalid payment method: " + method);
        }
    }
}
