package BowlingGameKata;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class GameTest {

    @ParameterizedTest
    @MethodSource(value = "testRollData")
    public void testRoll(int[] testRollData){
        Game game = new Game();
        game.roll(testRollData[0]);
        Assertions.assertEquals(testRollData[1], game.score());
    }

    @SuppressWarnings("unused")
    public static int[][] testRollData(){
        return new int[][]{{0,0},{6,6}};
    }
}
