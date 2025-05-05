package com.example.lld.wallet.service;

import com.example.lld.wallet.model.User;
import com.example.lld.wallet.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public void registerUser(String id, String name) {
        if (!userRepository.exists(id)) {
            userRepository.save(new User(id, name));
        }
    }

    public User getUser(String id) {
        return userRepository.getById(id);
    }
}
