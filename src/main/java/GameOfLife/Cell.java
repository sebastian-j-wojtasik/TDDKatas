package GameOfLife;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cell {
    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Cell> getNeighbours(List<Cell> grid) {
        return grid.stream().filter(this::isNeighbour).collect(Collectors.toList());
    }

    private boolean isNeighbour(Cell cell) {

        return (cell.getX() >= this.getX() - 1 && cell.getX() <= this.getX() + 1) && (cell.getY() >= this.getY() - 1 && cell.getY() <= this.getY() + 1);
    }

    private int getY() {
        return this.y;
    }

    private int getX() {
        return this.x;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
