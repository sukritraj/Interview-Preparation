package com.example.lld.snakeLadder;

public class Player {
    private String name;
    private int position;


    public Player(String name) {
        this.name = name;
        this.position = 0; // start position
    }


    public String getName() { return name; }
    public int getPosition() { return position; }
    public void setPosition(int pos) { this.position = pos; }
}
