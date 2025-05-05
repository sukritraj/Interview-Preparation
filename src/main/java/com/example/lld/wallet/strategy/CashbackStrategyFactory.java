package com.example.lld.wallet.strategy;

public class CashbackStrategyFactory {
    public static CashbackStrategy getStrategy(String type) {
        return switch (type.toLowerCase()) {
            case "fixed" -> new FixedCashbackStrategy();
            default -> new NoCashbackStrategy();
        };
    }
}
