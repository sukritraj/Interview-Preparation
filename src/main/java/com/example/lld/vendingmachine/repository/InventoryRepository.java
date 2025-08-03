package com.example.lld.vendingmachine.repository;

import com.example.lld.vendingmachine.model.Item;

import java.util.HashMap;
import java.util.Map;

public class InventoryRepository {
    private final Map<Item, Integer> stock = new HashMap<>();

    public void addStock(Item item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
    }

    public void reduceStock(Item item) {
        if (getQuantity(item) <= 0) {
            throw new RuntimeException("Out of stock: " + item.getName());
        }
        stock.put(item, stock.get(item) - 1);
    }

    public int getQuantity(Item item) {
        return stock.getOrDefault(item, 0);
    }

    public Item getItem(String code) {
        return stock.keySet().stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public void displayItems() {
        System.out.println("Available Items:");
        for (Item item : stock.keySet()) {
            System.out.printf("Code: %s | %s | ₹%d | Stock: %d%n",
                    item.getCode(), item.getName(), item.getPrice(), getQuantity(item));
        }
    }
}
