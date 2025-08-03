package com.example.lld.restaurantManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Integer> serviceablePincodes;
    private Food food;
    private int quantity;
    private List<Review> reviews = new ArrayList<>();

    public Restaurant(String name, List<Integer> serviceablePincodes, Food food, int quantity) {
        this.name = name;
        this.serviceablePincodes = serviceablePincodes;
        this.food = food;
        this.quantity = quantity;
    }

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public void reduceQuantity(int qty) {
        this.quantity -= qty;
    }

    public boolean isServiceable(int userPincode) {
        return serviceablePincodes.contains(userPincode) && quantity > 0;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        return reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getServiceablePincodes() {
        return serviceablePincodes;
    }

    public void setServiceablePincodes(List<Integer> serviceablePincodes) {
        this.serviceablePincodes = serviceablePincodes;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}

