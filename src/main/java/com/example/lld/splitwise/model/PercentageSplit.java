package com.example.lld.splitwise.model;

public class PercentageSplit extends Split {
    private final double percent;

    public PercentageSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}