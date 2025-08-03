package com.example.lld.restaurantManagement.repository;

import com.example.lld.restaurantManagement.model.Review;

import java.util.*;

public class ReviewRepository {
    private final Map<String, List<Review>> reviewsByRestaurant = new HashMap<>();

    public void save(Review review) {
        reviewsByRestaurant
                .computeIfAbsent(review.getRestaurantName(), k -> new ArrayList<>())
                .add(review);
    }

    public List<Review> getReviewsByRestaurant(String restaurantName) {
        return reviewsByRestaurant.getOrDefault(restaurantName, Collections.emptyList());
    }

    public List<Review> getAllReviews() {
        return reviewsByRestaurant.values()
                .stream()
                .flatMap(List::stream)
                .toList();
    }
}
