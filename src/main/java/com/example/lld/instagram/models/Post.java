package com.example.lld.instagram.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Post {

    private final int id;
    private final int authorId;
    private final String content;
    private final long timestamp;
    private final Set<String> hashtags;


    private final Set<Integer> likes = ConcurrentHashMap.newKeySet();
    private final List<Comment> comments = Collections.synchronizedList(new ArrayList<>());


    public Post(int id, int authorId, String content, long timestamp, Set<String> hashtags) {
        this.id = id;
        this.authorId = authorId;
        this.content = content;
        this.timestamp = timestamp;
        this.hashtags = hashtags;
    }

    public int getId() {
        return id;
    }


    public int getAuthorId() {
        return authorId;
    }


    public String getContent() {
        return content;
    }


    public long getTimestamp() {
        return timestamp;
    }


    public Set<String> getHashtags() {
        return hashtags;
    }

    public void addLike(int userId) {
        likes.add(userId);
    }


    public void removeLike(int userId) {
        likes.remove(userId);
    }


    public int getLikesCount() {
        return likes.size();
    }


    public Set<Integer> getLikes() {
        return likes;
    }


    public void addComment(Comment comment) {
        comments.add(comment);
    }


    public List<Comment> getComments() {
        return comments;
    }


}
