package com.example.lld.restaurantManagement.strategy;

import com.example.lld.restaurantManagement.model.Restaurant;

import java.util.List;

public interface RestaurantSortStrategy {
    List<Restaurant> sort(List<Restaurant> restaurants);
}
