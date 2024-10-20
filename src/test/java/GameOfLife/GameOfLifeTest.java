package GameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {
    @Test
    void gameOfLifeGridSizeIsTheSameAsInConstructor() {
        GameOfLife gameOfLife = new GameOfLife(3,3);
        int[] gridSize  = gameOfLife.getGridSize();
        Assertions.assertArrayEquals(gridSize, new int[]{3,3});
    }
}
