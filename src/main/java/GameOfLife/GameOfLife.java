package GameOfLife;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GameOfLife {
    private Cell[][] grid;

    GameOfLife(int rows, int columns) {
        this.grid = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = new Cell(row,column);
            }
        }
    }

    int[] getGridSize() {
        return new int[]{grid.length, grid[0].length};
    }

    List<Cell> getCells() {
        return Arrays.stream(grid).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    Cell getCell(int x, int y) {
        return grid[x][y];
    }

    void play(){
        for (int i = 0; i < 100; i++) {
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[0].length; column++) {
                    System.out.print(grid[row][column].isAlive() ? " A " : " D ");
                }
                System.out.println();
            }
            update();
            System.out.println();
        }
    }

    void update() {
        Cell[][] copyGrid = createGridCopy();
        for(int row = 0; row < this.grid.length; row++){
            for(int column = 0; column < this.grid[0].length; column++){
                Cell cell = grid[row][column];
                long livingNeighbours = cell.getNeighbours(getCells()).stream().filter(c->c.isAlive()).count();
                if(livingNeighbours<2 && cell.isAlive()){
                    copyGrid[row][column].setAlive(false);
                }if(livingNeighbours>3 && cell.isAlive()){
                    copyGrid[row][column].setAlive(false);
                }else if( livingNeighbours==3 && !cell.isAlive()){
                    copyGrid[row][column].setAlive(true);
                }
            }
        }
        this.grid = copyGrid;
    }

    private Cell[][] createGridCopy() {
        Cell[][] copyGrid= new Cell[this.grid.length][this.grid[0].length];
        for(int row = 0; row < this.grid.length; row++){
            for(int column = 0; column < this.grid[0].length; column++){
                copyGrid[row][column]= new Cell(grid[row][column]);
            }
        }
        return copyGrid;
    }
}
