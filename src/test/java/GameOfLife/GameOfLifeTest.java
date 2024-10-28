package GameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLifeTest {
    @ParameterizedTest
    @MethodSource(value = "gridSizeData")
    void gameOfLifeGridSizeIsTheSameAsInConstructor(int[] gridSizeData) {
        GameOfLife gameOfLife = new GameOfLife(gridSizeData[0],gridSizeData[1]);
        int[] gridSize  = gameOfLife.getGridSize();
        Assertions.assertArrayEquals(gridSize, new int[]{gridSizeData[0],gridSizeData[1]});
    }

    @Test
    void gameIsInitializedWithArrayOfCells(){
        GameOfLife gameOfLife = new GameOfLife(10,10);
        List<Cell> cells = gameOfLife.getCells().stream().filter(Objects::nonNull).collect(Collectors.toList());
        boolean isEmpty = cells.isEmpty();
        Assertions.assertFalse(isEmpty);
    }


    @ParameterizedTest
    @MethodSource(value = "neighboursData")
    void firstCellInFirstPositionHaveNeighbours(int[] neighboursData) {
        GameOfLife gameOfLife = new GameOfLife(neighboursData[0],neighboursData[1]);
        Cell cell = gameOfLife.getCell(neighboursData[2],neighboursData[3]);
        boolean hasNeighbours = cell.getNeighbours(gameOfLife.getCells()).isEmpty();
        Assertions.assertFalse(hasNeighbours);
    }

    @Test
    void livingCellWithLessThanTwoLivingNeighboursDies() {
        GameOfLife gameOfLife = new GameOfLife(5,5);
        Cell cell = gameOfLife.getCell(2,2);
        cell.setAlive(true);
        List<Cell> cells = gameOfLife.getCells();
        List<Cell> neighbours = cell.getNeighbours(cells);
        neighbours.forEach(c->c.setAlive(false));
        gameOfLife.update();
        cell = gameOfLife.getCell(2,2);
        Assertions.assertFalse(cell.isAlive());
    }

    @SuppressWarnings("unused")
    public static int[][] gridSizeData(){
        return new int[][]{{3,3},{7,3},{3,7}};
    }
    @SuppressWarnings("unused")
    public static int[][] neighboursData(){
        return new int[][]{{3,3,2,2},{7,7,3,2},{3,7,1,2}};
    }
}
