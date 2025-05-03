package com.example.lld.zomato.restaurantManagement;

public class MenuItem {
    private String itemId;
    private String name;
    private double price;
    private int preparationTime;
    public MenuItem(String itemId, String name, double price, int preparationTime) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}
