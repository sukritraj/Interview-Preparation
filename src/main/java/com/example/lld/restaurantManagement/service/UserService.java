package com.example.lld.restaurantManagement.service;

import com.example.lld.restaurantManagement.model.User;
import com.example.lld.restaurantManagement.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private User currentUser;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String name, String mobile, String location, String gender) {
        if (userRepository.exists(name)) {
            System.out.println("User already exists");
            return;
        }
        User user = new User(name, mobile, location, gender);
        userRepository.save(user);
        System.out.println("User registered: " + name);
    }

    public void loginUser(String name) {
        if (!userRepository.exists(name)) {
            System.out.println("User not found!");
            return;
        }
        currentUser = userRepository.getByName(name);
        System.out.println("Logged in as: " + currentUser.getName());
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
