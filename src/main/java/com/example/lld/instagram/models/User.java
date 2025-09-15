package com.example.lld.instagram.models;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private final int id;
    private final String username;


    // Following relationships
    private final Set<Integer> followingUsers = ConcurrentHashMap.newKeySet();
    private final Set<String> followingHashtags = ConcurrentHashMap.newKeySet();


    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }


    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public Set<Integer> getFollowingUsers() {
        return followingUsers;
    }


    public Set<String> getFollowingHashtags() {
        return followingHashtags;
    }
}
