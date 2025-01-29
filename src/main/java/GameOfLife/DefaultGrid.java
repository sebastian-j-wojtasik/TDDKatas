package GameOfLife;

class DefaultGrid implements GridFactory {
    @Override
    public Cell[][] createGrid(int rows, int columns) {
        Cell[][] grid = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = new Cell(row,column);
            }
        }
        return grid;
    }
}
