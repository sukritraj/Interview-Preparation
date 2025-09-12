package com.example.lld.ticTacToe;

public class Player {
    private final String id;
    private final String name;
    private final Mark mark;
    public Player(String id, String name, Mark mark) {
        this.id = id; this.name = name; this.mark = mark;
    }
    public Mark getMark() { return mark; }
    public String getName() { return name; }
    public String getId() { return id; }
}
