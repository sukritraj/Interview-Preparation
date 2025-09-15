package com.example.lld.instagram.repositories;

import com.example.lld.instagram.models.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {
    private final AtomicInteger idGen = new AtomicInteger(1);
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final Map<String, User> usernameIndex = new ConcurrentHashMap<>();


    public User create(String username) {
        int id = idGen.getAndIncrement();
        User u = new User(id, username);
        users.put(id, u);
        usernameIndex.put(username.toLowerCase(), u);
        return u;
    }


    public User getById(int id) {
        return users.get(id);
    }


    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(usernameIndex.get(username.toLowerCase()));
    }
}
