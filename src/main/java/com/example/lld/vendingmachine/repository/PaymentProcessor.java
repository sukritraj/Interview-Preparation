package com.example.lld.vendingmachine.repository;

public class PaymentProcessor {
    private int balance = 0;

    public void addMoney(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public int refund() {
        int temp = balance;
        balance = 0;
        return temp;
    }
}
