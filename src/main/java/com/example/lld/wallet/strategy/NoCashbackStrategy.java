package com.example.lld.wallet.strategy;

public class NoCashbackStrategy implements CashbackStrategy{
    @Override
    public double calculateCashback(double amount) {
        return 0.0;
    }
}
