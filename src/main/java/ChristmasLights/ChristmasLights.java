package ChristmasLights;

import java.util.Arrays;
import java.util.Map;

public class ChristmasLights {

    private final int[][] grid = new int[999][999];

    public boolean areAllOff() {
       return Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(a -> a != 0).findAny().isEmpty();
    }

    public void configure(Map<String, Integer[]> instructions) {

    }
}
