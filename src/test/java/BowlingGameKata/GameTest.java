package BowlingGameKata;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GameTest {

    @ParameterizedTest
    @MethodSource(value = "testRollData")
    public void testRoll(int[] testRollData){
        Game game = new Game();
        game.roll(testRollData[0]);
        Assertions.assertEquals(testRollData[1], game.score());
    }

    @ParameterizedTest
    @MethodSource(value = "testFrameData")
    public void testFrame(int[] testFrameData){
        Game game = new Game();
        game.frame(testFrameData[0], testFrameData[1]);
        Assertions.assertEquals(testFrameData[2], game.score());
    }

    @ParameterizedTest
    @MethodSource(value = "testSpareData")
    public void testSpareInFrame(int[] testSpareData){
        Game game = new Game();
        game.frame(testSpareData[0], testSpareData[1]);
        game.frame(testSpareData[2], testSpareData[3]);
        Assertions.assertEquals(testSpareData[4], game.score());
    }

    @ParameterizedTest
    @MethodSource(value = "testStrikeData")
    public void testStrikeInFrame(int[] testStrikeData){
        Game game = new Game();
        game.frame(testStrikeData[0], testStrikeData[1]);
        game.frame(testStrikeData[2], testStrikeData[3]);
        Assertions.assertEquals(testStrikeData[4], game.score());
    }

    @Test
    public void testBiggerAmountOfFrames(){
        Game game = new Game();
        game.frame(10, 0);
        game.frame(3, 3);
        game.frame(7, 3);
        game.frame(3, 3);
        Assertions.assertEquals(41, game.score());
    }

    @ParameterizedTest
    @MethodSource(value = "testGameData")
    public void testGame(List<Integer> testGameData){
        Game game = new Game();
        game.gamePlayed(testGameData);
        Assertions.assertEquals(testGameData.get(testGameData.size()-1), game.score());
    }

    @SuppressWarnings("unused")
    public static int[][] testRollData(){
        return new int[][]{{0,0},{6,6},{13,0},{-2,0}};
    }

    @SuppressWarnings("unused")
    public static int[][] testFrameData(){
        return new int[][]{{0,0,0},{13,0,0},{6,3,9}};
    }

    @SuppressWarnings("unused")
    public static int[][] testSpareData(){
        return new int[][]{{0,0,0,0,0,0},{6,4,4,3,21},{4,-2,3,1,8}};
    }

    @SuppressWarnings("unused")
    public static int[][] testStrikeData(){
        return new int[][]{{0,0,0,0,0,0},{10,0,4,3,24},{10,0,3,1,18},{10,4,3,1,18},{10,9,4,1,20},{10,0,8,2,30}};
    }

    @SuppressWarnings("unused")
    public static Stream<List<Integer>> testGameData(){
        return Stream.of(
                List.of(4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,80),
                List.of(10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,190),
                List.of(10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,7,204)
        );
    }
}