package com.example.lld.instagram.services.interfaces;

public interface IFollowService {
    void followUser(int followerId, int followeeId);
    void unfollowUser(int followerId, int followeeId);
    void followHashtag(int userId, String hashtag);
    void unfollowHashtag(int userId, String hashtag);
}
