package GameOfLife;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Cell {
    private final int x;
    private final int y;
    private boolean alive;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = Math.random() < 0.5;
    }

    public Cell(Cell cell) {
        this.x = cell.getX();
        this.y = cell.getY();
        this.alive = cell.isAlive();
    }

    public Cell(int x, int y,boolean alive){
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    List<Cell> getNeighbours(List<Cell> grid) {
        return grid.stream().filter(this::isNeighbour).collect(Collectors.toList());
    }

    long getLiveNeighbours(List<Cell> grid){
        return getNeighbours(grid).stream().filter(c->c.isAlive()).count();
    }

    private boolean isNeighbour(Cell cell) {
        return cell != this && (cell.getX() >= this.getX() - 1 && cell.getX() <= this.getX() + 1) && (cell.getY() >= this.getY() - 1 && cell.getY() <= this.getY() + 1);
    }

    private int getY() {
        return this.y;
    }

    private int getX() {
        return this.x;
    }

    void setAlive(boolean alive) {
        this.alive = alive;
    }

    boolean isAlive() {
        return this.alive;
    }
}
