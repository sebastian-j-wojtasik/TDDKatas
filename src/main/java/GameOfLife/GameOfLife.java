package GameOfLife;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GameOfLife {
    private Cell[][] grid;

    public GameOfLife(int rows, int columns) {
        this.grid = new Cell[rows][columns];
    }

    public int[] getGridSize() {
        return new int[]{grid.length, grid[0].length};
    }

    public List<Cell> getCells() {
        return Arrays.stream(grid).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
