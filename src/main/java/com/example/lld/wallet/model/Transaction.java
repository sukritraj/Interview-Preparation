package com.example.lld.wallet.model;

import java.time.LocalDateTime;

public class Transaction {
    private final String senderId;
    private final String receiverId;
    private final double amount;
    private final double cashback;
    private final LocalDateTime timestamp;

    public Transaction(String senderId, String receiverId, double amount, double cashback) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.cashback = cashback;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction from " + senderId + " to " + receiverId +
                " | Amount: " + amount + " | Cashback: " + cashback +
                " | Time: " + timestamp;
    }
}
