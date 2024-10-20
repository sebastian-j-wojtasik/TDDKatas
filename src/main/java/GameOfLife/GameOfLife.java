package GameOfLife;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GameOfLife {
    private final Cell[][] grid;

    GameOfLife(int rows, int columns) {
        this.grid = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = new Cell();
            }
        }
    }

    int[] getGridSize() {
        return new int[]{grid.length, grid[0].length};
    }

    List<Cell> getCells() {
        return Arrays.stream(grid).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
