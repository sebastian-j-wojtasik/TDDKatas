package GameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class GameOfLifeTest {
    @ParameterizedTest
    @MethodSource(value = "gameOfLifeGridSizeIsTheSameAsInConstructorValue")
    void gameOfLifeGridSizeIsTheSameAsInConstructor(int[] data) {
        GameOfLife gameOfLife = new GameOfLife(data[0],data[1], new DefaultGrid());
        Assertions.assertArrayEquals(gameOfLife.getGridSize(), new int[]{data[0],data[1]});
    }

    @Test
    void gameIsInitializedWithArrayOfCells(){
        GameOfLife gameOfLife = new GameOfLife(10,10, new DefaultGrid());;
        Assertions.assertFalse(gameOfLife.isGridInitalized());
    }

    @Test
    void livingCellWithLessThanTwoLivingNeighboursDies() {
        GameOfLife gameOfLife = new GameOfLife(3,3, new CustomGrid(
                new int[][]{
                        {0,0,0},
                        {0,1,0},
                        {0,0,0}
                }));
        gameOfLife.update();
        Assertions.assertFalse(gameOfLife.getCell(1,1).isAlive());
    }

    @Test
    void livingCellWithTwoNeighboursSurvive() {
        GameOfLife gameOfLife = new GameOfLife(3,3, new CustomGrid(
                new int[][]{
                        {0,1,0},
                        {0,1,0},
                        {0,1,0}
                }));
        gameOfLife.update();
        Assertions.assertTrue(gameOfLife.getCell(1,1).isAlive());
    }

    @Test
    void livingCellWithThreeNeighboursSurvive() {
        GameOfLife gameOfLife = new GameOfLife(3,3, new CustomGrid(
                new int[][]{
                        {0,1,0},
                        {0,1,1},
                        {0,1,0}
                }));
        gameOfLife.update();
        Assertions.assertTrue(gameOfLife.getCell(1,1).isAlive());
    }

    @Test
    void livingCellWithMoreThaThreeNeighboursDies() {
        GameOfLife gameOfLife = new GameOfLife(3,3, new CustomGrid(
                new int[][]{
                        {0,1,1},
                        {0,1,1},
                        {0,1,0}
                }));
        gameOfLife.update();
        Assertions.assertFalse(gameOfLife.getCell(1,1).isAlive());
    }

    @Test
    void deadCellWithExactlyThreeNeighboursResurrect() {
        GameOfLife gameOfLife = new GameOfLife(3,3, new CustomGrid(
                new int[][]{
                        {0,1,1},
                        {0,0,0},
                        {0,1,0}
                }));
        gameOfLife.update();
        Assertions.assertTrue(gameOfLife.getCell(1,1).isAlive());
    }

    @Test
    void playTheGame() {
    GameOfLife gameOfLife= new GameOfLife(30,30);
    gameOfLife.play();
    Assertions.assertTrue(true);
    }

    @SuppressWarnings("unused")
    public static int[][] gameOfLifeGridSizeIsTheSameAsInConstructorValue(){
        return new int[][]{{3,3},{7,3},{3,7}};
    }
    @SuppressWarnings("unused")
    public static int[][] firstCellInFirstPositionHaveNeighboursValue(){
        return new int[][]{{3,3,2,2},{7,7,3,2},{3,7,1,2}};
    }
    @SuppressWarnings("unused")
    public static int[][] livingCellWithTwoOrThreeNeighboursSurviveValue(){
        return new int[][]{{2},{3}};
    }

}
