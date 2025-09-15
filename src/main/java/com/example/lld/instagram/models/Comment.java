package com.example.lld.instagram.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Comment {
    private static final AtomicInteger ID_GEN = new AtomicInteger(1);
    private final int id;
    private final int userId;
    private final String text;
    private final long timestamp;


    public Comment(int userId, String text) {
        this.id = ID_GEN.getAndIncrement();
        this.userId = userId;
        this.text = text;
        this.timestamp = System.currentTimeMillis();
    }


    public int getId() {
        return id;
    }


    public int getUserId() {
        return userId;
    }


    public String getText() {
        return text;
    }


    public long getTimestamp() {
        return timestamp;
    }
}
