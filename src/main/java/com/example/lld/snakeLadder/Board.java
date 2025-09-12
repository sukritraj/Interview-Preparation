package com.example.lld.snakeLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;


    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }


    public void addSnake(int head, int tail) {
        snakes.put(head, tail);
    }


    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }


    public int getSize() { return size; }


    public int getNextPosition(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        return position;
    }
}
