package com.example.lld.instagram.services.strategies;

import com.example.lld.instagram.models.Post;
import com.example.lld.instagram.services.interfaces.IFeedRankingStrategy;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PopularityRecencyRanking implements IFeedRankingStrategy {
    private final double recencyWeight; // 0..1


    public PopularityRecencyRanking(double recencyWeight) {
        this.recencyWeight = recencyWeight;
    }


    @Override
    public List<Post> rank(Collection<Post> candidates, int limit) {
        long now = System.currentTimeMillis();
        return candidates.stream()
                .sorted((a, b) -> Double.compare(score(b, now), score(a, now)))
                .limit(limit)
                .collect(Collectors.toList());
    }


    private double score(Post p, long now) {
        double ageSeconds = Math.max(1, (now - p.getTimestamp()) / 1000.0);
        double recencyScore = 1.0 / Math.log(ageSeconds + 1);
        double popularityScore = Math.log(1 + p.getLikesCount());
        return recencyWeight * recencyScore + (1 - recencyWeight) * popularityScore;
    }
}
