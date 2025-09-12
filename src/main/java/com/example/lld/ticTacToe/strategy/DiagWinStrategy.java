package com.example.lld.ticTacToe.strategy;

import com.example.lld.ticTacToe.model.Board;
import com.example.lld.ticTacToe.model.Mark;

public class DiagWinStrategy implements WinStrategy {
    @Override
    public boolean checkWin(Board board, Mark mark) {
        int n = board.getSize();
        boolean main = true;
        for (int i = 0; i < n; i++) {
            if (board.getCell(i, i) != mark) { main = false; break; }
        }
        if (main) return true;
        boolean anti = true;
        for (int i = 0; i < n; i++) {
            if (board.getCell(i, n - 1 - i) != mark) { anti = false; break; }
        }
        return anti;
    }
}
