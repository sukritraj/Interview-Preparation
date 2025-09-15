package com.example.lld.instagram.services.implementations;

import com.example.lld.instagram.models.Comment;
import com.example.lld.instagram.models.Post;
import com.example.lld.instagram.models.User;
import com.example.lld.instagram.repositories.PostRepository;
import com.example.lld.instagram.repositories.UserRepository;
import com.example.lld.instagram.services.interfaces.IPostService;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostService implements IPostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;


    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");


    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Post createPost(int authorId, String content) {
        User u = userRepo.getById(authorId);
        if (u == null) throw new IllegalArgumentException("Author not found: " + authorId);
        Set<String> tags = extractHashtags(content);
        return postRepo.create(authorId, content, tags);
    }


    private Set<String> extractHashtags(String content) {
        Set<String> tags = new HashSet<>();
        Matcher m = HASHTAG_PATTERN.matcher(content);
        while (m.find()) {
            tags.add(m.group().toLowerCase());
        }
        return tags;
    }


    @Override
    public void likePost(int userId, int postId) {
        Post p = postRepo.getById(postId);
        if (p == null) throw new IllegalArgumentException("Post not found: " + postId);
        p.addLike(userId);
    }


    @Override
    public void commentPost(int userId, int postId, String text) {
        Post p = postRepo.getById(postId);
        if (p == null) throw new IllegalArgumentException("Post not found: " + postId);
        p.addComment(new Comment(userId, text));
    }


    @Override
    public Post getPost(int postId) {
        return postRepo.getById(postId);
    }
}
