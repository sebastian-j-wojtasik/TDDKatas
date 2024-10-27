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


    @Test
    void firstCellInFirstPositionHaveNeighbours() {
        GameOfLife gameOfLife = new GameOfLife(2,2);
        Cell cell = gameOfLife.getCell(0,0);
        boolean hasNeighbours = cell.getNeighbours().isEmpty;
        Assertions.assertTrue(hasNeighbours);
    }

    @SuppressWarnings("unused")
    public static int[][] gridSizeData(){
        return new int[][]{{3,3},{7,3},{3,7}};
    }
}
