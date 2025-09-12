package com.example.lld.ticTacToe.model;

public final class BoardFactory {
    private BoardFactory() {}


    public static Board createDefaultBoard() { return new Board(3); }
    public static Board createBoard(int size) { return new Board(size); }
}
