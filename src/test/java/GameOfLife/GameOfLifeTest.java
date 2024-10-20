package GameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameOfLifeTest {
    @Test
    void gameOfLifeGridSizeIsTheSameAsInConstructor() {
        GameOfLife gameOfLife = new GameOfLife(3,3);
        int[] gridSize  = gameOfLife.getGridSize();
        Assertions.assertArrayEquals(gridSize, new int[]{3,3});
    }

    @Test
    void gameIsInitializedWithArrayOfCells(){
        GameOfLife gameOfLife = new GameOfLife(10,10);
        List<Cell> cells = gameOfLife.getCells();
        boolean isNotEmpty = cells.isEmpty();
        Assertions.assertFalse(isNotEmpty);
    }
}
