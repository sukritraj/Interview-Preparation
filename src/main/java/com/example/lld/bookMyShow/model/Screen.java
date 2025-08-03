package com.example.lld.bookMyShow.model;

public class Screen {
    private String screenName;
    private int capacity;

    public Screen(String screenName, int capacity) {
        this.screenName = screenName;
        this.capacity = capacity;
    }

    public String getScreenName() {
        return screenName;
    }

    public int getCapacity() {
        return capacity;
    }
}

