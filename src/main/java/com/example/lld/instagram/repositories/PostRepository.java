package com.example.lld.instagram.repositories;

import com.example.lld.instagram.models.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PostRepository {

    private final AtomicInteger idGen = new AtomicInteger(1);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    // Simple hashtag index -> list of post ids (keeps insertion order)
    private final Map<String, List<Integer>> hashtagIndex = new ConcurrentHashMap<>();


    // Per-author posts (optional index)
    private final Map<Integer, List<Integer>> authorIndex = new ConcurrentHashMap<>();


    public Post save(Post p) {
        posts.put(p.getId(), p);
        for (String tag : p.getHashtags()) {
            hashtagIndex.computeIfAbsent(tag.toLowerCase(), k -> Collections.synchronizedList(new ArrayList<>())).add(p.getId());
        }
        authorIndex.computeIfAbsent(p.getAuthorId(), k -> Collections.synchronizedList(new ArrayList<>())).add(p.getId());
        return p;
    }


    public Post create(int authorId, String content, Set<String> hashtags) {
        int id = idGen.getAndIncrement();
        Post p = new Post(id, authorId, content, System.currentTimeMillis(), hashtags);
        return save(p);
    }


    public Post getById(int id) {
        return posts.get(id);
    }


    public List<Post> getPostsByAuthor(int authorId) {
        List<Integer> ids = authorIndex.getOrDefault(authorId, Collections.emptyList());
        return ids.stream().map(posts::get).filter(Objects::nonNull).collect(Collectors.toList());
    }


    public List<Post> getPostsByHashtag(String hashtag) {
        List<Integer> ids = hashtagIndex.getOrDefault(hashtag.toLowerCase(), Collections.emptyList());
        return ids.stream().map(posts::get).filter(Objects::nonNull).collect(Collectors.toList());
    }


    public List<Post> getAllRecent(int limit) {
        return posts.values().stream()
                .sorted(Comparator.comparingLong(Post::getTimestamp).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}
