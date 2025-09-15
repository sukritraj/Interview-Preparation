package com.example.lld.instagram.services.interfaces;

import com.example.lld.instagram.models.Post;

import java.util.List;

public interface IFeedService {
    List<Post> getPersonalizedFeed(int userId, int limit);
}
