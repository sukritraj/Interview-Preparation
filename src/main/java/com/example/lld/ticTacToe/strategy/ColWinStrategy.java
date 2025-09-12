package com.example.lld.ticTacToe.strategy;

import com.example.lld.ticTacToe.model.Board;
import com.example.lld.ticTacToe.model.Mark;

public class ColWinStrategy implements WinStrategy {
    @Override
    public boolean checkWin(Board board, Mark mark) {
        int n = board.getSize();
        for (int c = 0; c < n; c++) {
            boolean all = true;
            for (int r = 0; r < n; r++) {
                if (board.getCell(r, c) != mark) { all = false; break; }
            }
            if (all) return true;
        }
        return false;
    }
}
