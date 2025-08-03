package com.example.lld.restaurantManagement.strategy;

import com.example.lld.restaurantManagement.model.Restaurant;

import java.util.List;

public class DefaultSortStrategy implements RestaurantSortStrategy {
    @Override
    public List<Restaurant> sort(List<Restaurant> restaurants) {
        return restaurants;
    }
}
