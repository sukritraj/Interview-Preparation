package com.example.lld.restaurantManagement.model;

public class Food {
    private String name;
    private String type;
    private double price;

    public Food(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
