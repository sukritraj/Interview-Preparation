package com.example.lld.ticTacToe;

public class Board {
    private final int size;
    private final Mark[][] grid;
    public Board(int size) {
        this.size = size;
        this.grid = new Mark[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = Mark.EMPTY;
    }

    public int getSize() { return size; }
    public Mark getCell(int r, int c) { return grid[r][c]; }
    public boolean placeMark(int r, int c, Mark mark) {
        if (r < 0 || r >= size || c < 0 || c >= size) return false;
        if (grid[r][c] != Mark.EMPTY) return false;
        grid[r][c] = mark;
        return true;
    }
    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == Mark.EMPTY) return false;
        return true;
    }
    public Mark[][] getSnapshot() {
        Mark[][] snap = new Mark[size][size];
        for (int i = 0; i < size; i++)
            System.arraycopy(grid[i], 0, snap[i], 0, size);
        return snap;
    }
}
