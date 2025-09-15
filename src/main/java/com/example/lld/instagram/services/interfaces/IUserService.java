package com.example.lld.instagram.services.interfaces;

import com.example.lld.instagram.models.User;

import java.util.Optional;

public interface IUserService {
    User createUser(String username);
    Optional<User> findByUsername(String username);
    User getById(int id);
}
