package com.example.lld.restaurantManagement.repository;

import com.example.lld.restaurantManagement.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepository {
    private final Map<String, Restaurant> restaurants = new HashMap<>();

    public void save(Restaurant r) {
        restaurants.put(r.getName(), r);
    }

    public Restaurant getByName(String name) {
        return restaurants.get(name);
    }

    public List<Restaurant> getAll() {
        return new ArrayList<>(restaurants.values());
    }

    public boolean exists(String name) {
        return restaurants.containsKey(name);
    }
}

