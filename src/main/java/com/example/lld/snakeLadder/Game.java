package com.example.lld.snakeLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Dice dice;


    public Game(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = new LinkedList<>(players);
        this.dice = dice;
    }


    public void start() {
        while (true) {
            Player current = players.poll();
            int roll = dice.roll();
            int newPos = current.getPosition() + roll;


            if (newPos <= board.getSize()) {
                newPos = board.getNextPosition(newPos);
                current.setPosition(newPos);
            }


            System.out.println(current.getName() + " rolled " + roll + " → moved to " + current.getPosition());


            if (current.getPosition() == board.getSize()) {
                System.out.println("🏆 Winner: " + current.getName());
                break;
            }


            players.offer(current); // put player back in queue
        }
    }
}
