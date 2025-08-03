package com.example.lld.splitwise.service;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private final Map<String, Map<String, Double>> sheet = new HashMap<>();

    public void update(String fromUser, String toUser, double amount) {
        sheet.putIfAbsent(fromUser, new HashMap<>());
        Map<String, Double> inner = sheet.get(fromUser);
        inner.put(toUser, inner.getOrDefault(toUser, 0.0) + amount);
    }

    public void printBalances() {
        for (String u1 : sheet.keySet()) {
            for (String u2 : sheet.get(u1).keySet()) {
                double amt = sheet.get(u1).get(u2);
                if (amt > 0) {
                    System.out.printf("%s owes %s ₹%.2f\n", u1, u2, amt);
                }
            }
        }
    }

    public void settleUp(String fromUser, String toUser) {
        if (sheet.containsKey(fromUser) && sheet.get(fromUser).containsKey(toUser)) {
            double amount = sheet.get(fromUser).get(toUser);
            sheet.get(fromUser).remove(toUser);
            System.out.printf("✅ %s settled up with %s for ₹%.2f\n", fromUser, toUser, amount);
        } else {
            System.out.println("❌ No balance to settle between " + fromUser + " and " + toUser);
        }
    }
}