package com.example.lld.instagram;

import com.example.lld.instagram.models.Comment;
import com.example.lld.instagram.models.Post;
import com.example.lld.instagram.models.User;
import com.example.lld.instagram.repositories.PostRepository;
import com.example.lld.instagram.repositories.UserRepository;
import com.example.lld.instagram.services.implementations.FeedService;
import com.example.lld.instagram.services.implementations.FollowService;
import com.example.lld.instagram.services.implementations.PostService;
import com.example.lld.instagram.services.implementations.UserService;
import com.example.lld.instagram.services.interfaces.*;
import com.example.lld.instagram.services.strategies.RecentFirstRanking;

import java.time.Instant;
import java.util.List;

public class InstagramCloneApp {
    public  static void main(String[] args) throws InterruptedException {
        // Bootstrap services
        UserRepository userRepo = new UserRepository();
        PostRepository postRepo = new PostRepository();


        IUserService userService = new UserService(userRepo);
        IPostService postService = new PostService(postRepo, userRepo);
        IFollowService followService = new FollowService(userRepo);
// Feed service with a simple recent-first ranking strategy
        IFeedRankingStrategy ranking = new RecentFirstRanking();
        IFeedService feedService = new FeedService(userRepo, postRepo, ranking);


// Create users
        User alice = userService.createUser("alice");
        User bob = userService.createUser("bob_influencer");
        User carol = userService.createUser("carol");


// Follow users and hashtags
        followService.followUser(alice.getId(), bob.getId());
        followService.followHashtag(alice.getId(), "#travel");
        followService.followHashtag(alice.getId(), "#food");


// Bob creates a post with hashtags
        Post p1 = postService.createPost(bob.getId(), "Sunset in Goa! #travel #sunset");
        Thread.sleep(10);
        Post p2 = postService.createPost(carol.getId(), "Best pasta recipe #food #cooking");
        Thread.sleep(10);
        Post p3 = postService.createPost(bob.getId(), "Behind the scenes of my shoot #travel #work");


// Likes and comments
        postService.likePost(alice.getId(), p1.getId());
        postService.likePost(carol.getId(), p1.getId());
        postService.commentPost(alice.getId(), p1.getId(), "Amazing shot!");
        postService.commentPost(carol.getId(), p2.getId(), "Share the recipe please :)");


// Also create a hashtag-only post (user adds popular hashtag)
        Post p4 = postService.createPost(carol.getId(), "Trying a new cafe today #food");


// Get Alice's feed
        List<Post> feed = feedService.getPersonalizedFeed(alice.getId(), 20);


        System.out.println("=== Alice's Feed ===");
        for (Post p : feed) {
            User author = userRepo.getById(p.getAuthorId());
            System.out.printf("Post[%d] by %s at %s\n", p.getId(), author.getUsername(), Instant.ofEpochMilli(p.getTimestamp()));
            System.out.println(" Text: " + p.getContent());
            System.out.println(" Hashtags: " + p.getHashtags());
            System.out.println(" Likes: " + p.getLikesCount() + " | Comments: " + p.getComments().size());
            if (!p.getComments().isEmpty()) {
                System.out.println(" Comments:");
                for (Comment c : p.getComments()) {
                    System.out.printf(" - %s: %s\n", userRepo.getById(c.getUserId()).getUsername(), c.getText());
                }
            }
            System.out.println();
        }


        // Example: Bob follows a hashtag
        followService.followHashtag(bob.getId(), "#cooking");
        System.out.println("\nBob follows #cooking, his feed: ");
        List<Post> bobFeed = feedService.getPersonalizedFeed(bob.getId(), 10);
        for (Post p : bobFeed) {
            System.out.printf("%d - %s : %s\n", p.getId(), userRepo.getById(p.getAuthorId()).getUsername(), p.getContent());
        }
    }
}
