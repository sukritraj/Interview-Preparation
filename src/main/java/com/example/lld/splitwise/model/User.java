package com.example.lld.splitwise.model;

public class User {
    private final String id;
    private final String name;
    private final String mobileNumber;

    public User(String id, String name, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }
    public String getId() { return id; }

    public String getName() { return name; }
}
