package com.example.lld.ticTacToe.model;

import java.util.Arrays;

public class Board {
    private final int size;
    private final Mark[][] grid;


    public Board(int size) {
        if (size <= 0) throw new IllegalArgumentException("Board size must be > 0");
        this.size = size;
        this.grid = new Mark[size][size];
        clear();
    }


    public int getSize() { return size; }


    public synchronized boolean placeMark(int r, int c, Mark mark) {
        validateCoordinates(r, c);
        if (grid[r][c] != Mark.EMPTY) return false;
        grid[r][c] = mark;
        return true;
    }


    public Mark getCell(int r, int c) {
        validateCoordinates(r, c);
        return grid[r][c];
    }


    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == Mark.EMPTY) return false;
        return true;
    }


    public Mark[][] getSnapshot() {
        Mark[][] snap = new Mark[size][size];
        for (int i = 0; i < size; i++) System.arraycopy(grid[i], 0, snap[i], 0, size);
        return snap;
    }


    public void clear() {
        for (int i = 0; i < size; i++)
            Arrays.fill(grid[i], Mark.EMPTY);
    }


    private void validateCoordinates(int r, int c) {
        if (r < 0 || r >= size || c < 0 || c >= size)
            throw new IndexOutOfBoundsException("Coordinates out of bounds: (" + r + "," + c + ")");
    }
}