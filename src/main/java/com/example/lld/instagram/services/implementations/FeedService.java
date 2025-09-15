package com.example.lld.instagram.services.implementations;

import com.example.lld.instagram.models.Post;
import com.example.lld.instagram.models.User;
import com.example.lld.instagram.repositories.PostRepository;
import com.example.lld.instagram.repositories.UserRepository;
import com.example.lld.instagram.services.interfaces.IFeedRankingStrategy;
import com.example.lld.instagram.services.interfaces.IFeedService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeedService implements IFeedService {
    private final UserRepository userRepo;
    private final PostRepository postRepo;
    private final IFeedRankingStrategy ranking;


    public FeedService(UserRepository userRepo, PostRepository postRepo, IFeedRankingStrategy ranking) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.ranking = ranking;
    }


    @Override
    public List<Post> getPersonalizedFeed(int userId, int limit) {
        User u = userRepo.getById(userId);
        if (u == null) throw new IllegalArgumentException("User not found");


        Set<Post> candidates = new HashSet<>();


// Add posts from followed users
        for (Integer followedUserId : u.getFollowingUsers()) {
            candidates.addAll(postRepo.getPostsByAuthor(followedUserId));
        }


// Add posts for followed hashtags
        for (String tag : u.getFollowingHashtags()) {
            candidates.addAll(postRepo.getPostsByHashtag(tag));
        }


// If user follows no one / hashtags, fall back to recent posts
        if (candidates.isEmpty()) {
            candidates.addAll(postRepo.getAllRecent(limit * 2));
        }


// Rank and return
        return ranking.rank(candidates, limit);
    }
}
