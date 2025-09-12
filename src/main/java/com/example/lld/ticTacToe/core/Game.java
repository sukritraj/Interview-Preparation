package com.example.lld.ticTacToe.core;

import com.example.lld.ticTacToe.model.Board;
import com.example.lld.ticTacToe.model.GameStatus;
import com.example.lld.ticTacToe.model.Mark;
import com.example.lld.ticTacToe.model.Player;
import com.example.lld.ticTacToe.strategy.WinStrategy;

import java.util.List;

public class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;
    private GameStatus status;
    private final List<WinStrategy> strategies;

    public Game(Player pX, Player pO, int size, List<WinStrategy> strategies) {
        this.playerX = pX; this.playerO = pO;
        this.board = new Board(size);
        this.strategies = strategies;
        this.currentPlayer = playerX; // X starts
        this.status = GameStatus.IN_PROGRESS;
    }

    public GameStatus getStatus() { return status; }
    public Player getCurrentPlayer() { return currentPlayer; }
    public Mark[][] getBoardState() { return board.getSnapshot(); }

    public void makeMove(int r, int c) {
        if (status != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Game already completed: " + status);
        }
        boolean placed = board.placeMark(r, c, currentPlayer.getMark());
        if (!placed) {
            throw new IllegalArgumentException("Invalid move at (" + r + "," + c + ")");
        }
        // check win
        if (isWinner(currentPlayer.getMark())) {
            status = (currentPlayer.getMark() == Mark.X) ? GameStatus.X_WON : GameStatus.O_WON;
            return;
        }
        // check draw
        if (board.isFull()) {
            status = GameStatus.DRAW;
            return;
        }
        // switch player
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    private boolean isWinner(Mark mark) {
        for (WinStrategy s : strategies) {
            if (s.checkWin(board, mark)) return true;
        }
        return false;
    }

    public void reset() {
        // Recreate board or clear cells (recreate for simplicity)
        // In production provide proper reset logic.
        // Simple approach: reflect new Board construction:
        // (for brevity not implemented in code snippet)
    }
}
