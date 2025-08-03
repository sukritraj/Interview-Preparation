package com.example.lld.restaurantManagement.model;

public class Review {
    private String userName;
    private String restaurantName;
    private String comment;
    private double rating;

    public Review(String userName, String restaurantName, String comment, double rating) {
        this.userName = userName;
        this.restaurantName = restaurantName;
        this.comment = comment;
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getReviewText() {
        return comment;
    }

    public double getRating() {
        return rating;
    }
}
