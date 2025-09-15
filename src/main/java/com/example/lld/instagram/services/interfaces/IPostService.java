package com.example.lld.instagram.services.interfaces;

import com.example.lld.instagram.models.Post;

public interface IPostService {
    Post createPost(int authorId, String content);
    void likePost(int userId, int postId);
    void commentPost(int userId, int postId, String text);
    Post getPost(int postId);
}
