package com.example.lld.restaurantManagement.service;

import com.example.lld.restaurantManagement.factory.RestaurantSortStrategyFactory;
import com.example.lld.restaurantManagement.model.Restaurant;
import com.example.lld.restaurantManagement.repository.RestaurantRepository;
import com.example.lld.restaurantManagement.strategy.RestaurantSortStrategy;

import java.util.List;

public class DiscoveryService {
    private final RestaurantRepository restaurantRepository;

    public DiscoveryService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void showRestaurants(String criteria) {
        RestaurantSortStrategy strategy = RestaurantSortStrategyFactory.getSortStrategy(criteria);
        List<Restaurant> restaurants = restaurantRepository.getAll();
        List<Restaurant> sorted = strategy.sort(restaurants);
        sorted.forEach(restaurant -> {
            System.out.println("Restaurant Name: " + restaurant.getName());
            System.out.println("Cuisine: " + restaurant.getFood().getName());
            System.out.println("-----------------------------");
        });
    }
}
