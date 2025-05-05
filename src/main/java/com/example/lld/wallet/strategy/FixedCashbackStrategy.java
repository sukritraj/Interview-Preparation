package com.example.lld.wallet.strategy;

public class FixedCashbackStrategy implements CashbackStrategy{
    @Override
    public double calculateCashback(double amount) {
        return amount * 0.10;
    }
}
