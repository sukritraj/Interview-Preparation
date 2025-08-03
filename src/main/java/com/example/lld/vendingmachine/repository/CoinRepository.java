package com.example.lld.vendingmachine.repository;

import java.util.*;

public class CoinRepository {
    private final Map<Integer, Integer> coins = new HashMap<>();

    public void addCoins(int denomination, int count) {
        coins.put(denomination, coins.getOrDefault(denomination, 0) + count);
    }

    public boolean canProvideChange(int amount) {
        int remaining = amount;
        Map<Integer, Integer> temp = new HashMap<>(coins);

        List<Integer> denoms = new ArrayList<>(temp.keySet());
        denoms.sort(Collections.reverseOrder());

        for (int denom : denoms) {
            while (remaining >= denom && temp.get(denom) > 0) {
                remaining -= denom;
                temp.put(denom, temp.get(denom) - 1);
            }
        }
        return remaining == 0;
    }

    public List<Integer> getChange(int amount) throws Exception {
        int remaining = amount;
        List<Integer> change = new ArrayList<>();
        List<Integer> denoms = new ArrayList<>(coins.keySet());
        denoms.sort(Collections.reverseOrder());

        for (int denom : denoms) {
            while (remaining >= denom && coins.get(denom) > 0) {
                remaining -= denom;
                coins.put(denom, coins.get(denom) - 1);
                change.add(denom);
            }
        }

        if (remaining != 0) {
            throw new Exception("Cannot provide exact change for ₹" + amount);
        }

        return change;
    }
}

