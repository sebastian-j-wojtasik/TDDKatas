package GameOfLife;

class CustomGrid implements GridFactory {


    private final int[][] aliveCells;

    public CustomGrid(int[][] aliveCells) {
        this.aliveCells = aliveCells;
    }

    @Override
    public Cell[][] createGrid(int rows, int columns) {
        Cell[][] grid = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if(aliveCells[row][column]==1){
                    grid[row][column] = new Cell(row,column,true);
                }else{
                    grid[row][column] = new Cell(row,column,false);
                }
            }
        }
        return grid;
    }
}
