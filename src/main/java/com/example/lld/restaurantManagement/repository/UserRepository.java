package com.example.lld.restaurantManagement.repository;

import com.example.lld.restaurantManagement.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getName(), user);
    }

    public User getByName(String name) {
        return users.get(name);
    }

    public boolean exists(String name) {
        return users.containsKey(name);
    }
}
