package com.example.lld.zomato.userManagement;

import com.example.lld.zomato.restaurantManagement.Restaurant;

import java.util.List;

public class RestaurantOwner extends User {
    private List<Restaurant> ownedRestaurants;

    public RestaurantOwner(String userId, String name, String email, String phone, String address) {
        super(userId, name, email, phone, address);
    }
}

