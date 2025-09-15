package com.example.lld.instagram.services.implementations;

import com.example.lld.instagram.models.User;
import com.example.lld.instagram.repositories.UserRepository;
import com.example.lld.instagram.services.interfaces.IUserService;

import java.util.Optional;

public class UserService implements IUserService {
    private final UserRepository repo;


    public UserService(UserRepository repo) {
        this.repo = repo;
    }


    @Override
    public User createUser(String username) {
        return repo.create(username);
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }


    @Override
    public User getById(int id) {
        return repo.getById(id);
    }
}
