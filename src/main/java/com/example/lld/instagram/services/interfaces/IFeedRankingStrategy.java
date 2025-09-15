package com.example.lld.instagram.services.interfaces;

import com.example.lld.instagram.models.Post;

import java.util.Collection;
import java.util.List;

public interface IFeedRankingStrategy {
    List<Post> rank(Collection<Post> candidates, int limit);
}
