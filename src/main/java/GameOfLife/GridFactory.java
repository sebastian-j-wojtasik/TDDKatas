package GameOfLife;

interface GridFactory {
    Cell[][] createGrid(int rows, int columns);
}
