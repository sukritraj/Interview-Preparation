package com.example.lld.snakeLadder;

import java.util.Random;

public class Dice {
    private int faces;
    private Random random;

    public Dice(int faces) {
        this.faces = faces;
        this.random = new Random();
    }


    public int roll() {
        return random.nextInt(faces) + 1;
    }
}
