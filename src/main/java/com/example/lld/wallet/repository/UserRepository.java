package com.example.lld.wallet.repository;

import com.example.lld.wallet.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User getById(String userId) {
        return users.get(userId);
    }

    public boolean exists(String userId) {
        return users.containsKey(userId);
    }
}
