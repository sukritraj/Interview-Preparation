package com.example.lld.instagram.services.implementations;

import com.example.lld.instagram.models.User;
import com.example.lld.instagram.repositories.UserRepository;
import com.example.lld.instagram.services.interfaces.IFollowService;

public class FollowService implements IFollowService {
    private final UserRepository userRepo;


    public FollowService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public void followUser(int followerId, int followeeId) {
        User follower = userRepo.getById(followerId);
        User followee = userRepo.getById(followeeId);
        if (follower == null || followee == null) throw new IllegalArgumentException("User not found");
        follower.getFollowingUsers().add(followeeId);
    }


    @Override
    public void unfollowUser(int followerId, int followeeId) {
        User follower = userRepo.getById(followerId);
        if (follower == null) throw new IllegalArgumentException("User not found");
        follower.getFollowingUsers().remove(followeeId);
    }


    @Override
    public void followHashtag(int userId, String hashtag) {
        User u = userRepo.getById(userId);
        if (u == null) throw new IllegalArgumentException("User not found");
        u.getFollowingHashtags().add(normalizeTag(hashtag));
    }


    @Override
    public void unfollowHashtag(int userId, String hashtag) {
        User u = userRepo.getById(userId);
        if (u == null) throw new IllegalArgumentException("User not found");
        u.getFollowingHashtags().remove(normalizeTag(hashtag));
    }


    private String normalizeTag(String t) {
        return t.startsWith("#") ? t.toLowerCase() : ("#" + t.toLowerCase());
    }
}
