package com.example.design.lld.ecommerce;

public abstract class User {
    private int userId;
    private String username;
    private String password;
    private String email;

    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public abstract void viewProfile();
}

