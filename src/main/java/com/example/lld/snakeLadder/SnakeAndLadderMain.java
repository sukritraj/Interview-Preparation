package com.example.lld.snakeLadder;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderMain {
    public static void main(String[] args) {
        Board board = new Board(100);
        board.addSnake(99, 10);
        board.addSnake(90, 50);
        board.addLadder(5, 25);
        board.addLadder(40, 89);


        List<Player> players = Arrays.asList(new Player("Alice"), new Player("Bob"));


        Dice dice = new Dice(6);


        Game game = new Game(board, players, dice);
        game.start();
    }
}
