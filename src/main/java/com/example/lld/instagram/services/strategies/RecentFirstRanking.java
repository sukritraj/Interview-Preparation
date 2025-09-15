package com.example.lld.instagram.services.strategies;

import com.example.lld.instagram.models.Post;
import com.example.lld.instagram.services.interfaces.IFeedRankingStrategy;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecentFirstRanking implements IFeedRankingStrategy {
    @Override
    public List<Post> rank(Collection<Post> candidates, int limit) {
        return candidates.stream()
                .sorted(Comparator.comparingLong(Post::getTimestamp).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}
