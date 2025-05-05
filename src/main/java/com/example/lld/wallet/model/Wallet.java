package com.example.lld.wallet.model;

public class Wallet {
    private final String userId;
    private double balance;

    public Wallet(String userId) {
        this.userId = userId;
        this.balance = 0.0;
    }

    public double getBalance() { return balance; }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public String getUserId() {
        return userId;
    }
}