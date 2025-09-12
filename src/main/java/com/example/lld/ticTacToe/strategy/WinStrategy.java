package com.example.lld.ticTacToe.strategy;

import com.example.lld.ticTacToe.model.Board;
import com.example.lld.ticTacToe.model.Mark;

public interface WinStrategy {
    boolean checkWin(Board board, Mark mark);
}
