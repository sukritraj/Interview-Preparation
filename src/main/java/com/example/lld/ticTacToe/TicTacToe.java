package com.example.lld.ticTacToe;

import com.example.lld.ticTacToe.core.Game;
import com.example.lld.ticTacToe.model.Mark;
import com.example.lld.ticTacToe.model.Player;
import com.example.lld.ticTacToe.strategy.ColWinStrategy;
import com.example.lld.ticTacToe.strategy.DiagWinStrategy;
import com.example.lld.ticTacToe.strategy.RowWinStrategy;
import com.example.lld.ticTacToe.strategy.WinStrategy;

import java.util.Arrays;
import java.util.List;

public class TicTacToe {
    public static void main(String[] args) {
        Player p1 = new Player("1","Alice", Mark.X);
        Player p2 = new Player("2","Bob", Mark.O);
        List<WinStrategy> strategies = Arrays.asList(new RowWinStrategy(), new ColWinStrategy(), new DiagWinStrategy());
        Game game = new Game(p1, p2, 3, strategies);

        game.makeMove(0,0); // X
        game.makeMove(1,1); // O
        game.makeMove(0,1); // X
        game.makeMove(2,2); // O
        game.makeMove(0,2); // X -> X wins
        System.out.println(game.getStatus()); // X_WON
    }
}
