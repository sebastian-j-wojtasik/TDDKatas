package ChristmasLights;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ChristmasLights {

    private final int[][] grid = new int[999][999];

    public boolean areAllOff() {
       return Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(a -> a != 0).findAny().isEmpty();
    }

    public void configure(List<Instruction> instructions) {
        for(Instruction instruction : instructions){
            if("on".equals(instruction.getOperation())){
                for (int i = instruction.getFrom()[0]; i <=instruction.getThrough()[0]; i++) {
                    for (int j = instruction.getFrom()[1]; j <=instruction.getThrough()[1]; j++) {
                        grid[i][j] = 1;
                    }
                }
            }
        }
    }

    public boolean isTurnedOn(int x, int y) {
        return grid[x][y] == 1;
    }

    public boolean areOn(int[] from, int[] through) {
        return false;
    }
}
