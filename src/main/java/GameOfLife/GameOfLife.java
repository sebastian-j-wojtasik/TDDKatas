package GameOfLife;

class GameOfLife {
    private Cell[][] grid;

    public GameOfLife(int rows, int columns) {
        this.grid = new Cell[rows][columns];
    }

    public int[] getGridSize() {
        return new int[]{grid[0].length, grid[1].length};
    }
}
