package ChristmasLights;

import java.util.Arrays;

class Instruction {
    private final String operation;
    private final int[] from;
    private final int[] through;
    public Instruction(String operation, int[] from, int[] through) {
        this.operation = operation;
        this.from = from;
        this.through = through;
    }

    public String getOperation() {
        return operation;
    }

    public int[] getFrom() {
        return from;
    }

    public int[] getThrough() {
        return through;
    }
}
