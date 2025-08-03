package com.example.lld.restaurantManagement.service;

import com.example.lld.restaurantManagement.model.Restaurant;
import com.example.lld.restaurantManagement.model.Review;
import com.example.lld.restaurantManagement.repository.RestaurantRepository;
import com.example.lld.restaurantManagement.repository.ReviewRepository;

public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(RestaurantRepository restaurantRepo, ReviewRepository reviewRepo) {
        this.restaurantRepository = restaurantRepo;
        this.reviewRepository = reviewRepo;
    }

    public void createReview(String username, String restaurantName, double rating, String comment) {
        Restaurant restaurant = restaurantRepository.getByName(restaurantName);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }

        Review review = new Review(username, restaurantName, comment, rating);
        restaurant.addReview(review);
        reviewRepository.save(review);
        System.out.println("Review added successfully.");
    }
}

