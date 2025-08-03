package com.example.lld.restaurantManagement.strategy;

import com.example.lld.restaurantManagement.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class RatingSortStrategy implements RestaurantSortStrategy {
    @Override
    public List<Restaurant> sort(List<Restaurant> restaurants) {
        return restaurants.stream()
                .sorted((a, b) -> Double.compare(b.getAverageRating(), a.getAverageRating()))
                .collect(Collectors.toList());
    }
}

