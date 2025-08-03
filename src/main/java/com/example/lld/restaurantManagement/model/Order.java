package com.example.lld.restaurantManagement.model;

public class Order {
    private String orderId;
    private String restaurantName;
    private String userName;
    private String foodName;
    private double price;
    private String status;

    public Order(String orderId, String restaurantName, String userName, String foodName, double price, String status) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.userName = userName;
        this.foodName = foodName;
        this.price = price;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getUserName() {
        return userName;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
