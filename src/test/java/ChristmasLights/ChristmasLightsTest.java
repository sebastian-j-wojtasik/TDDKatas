package ChristmasLights;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ChristmasLightsTest {
    @Test
    void areLightsOffWithNoInstruction(){
        ChristmasLights christmasLights = new ChristmasLights();
        List<Instruction> instructions = new ArrayList<>();
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.areAllOff());
    }

    @Test
    void testTurningOnTheLight(){
        ChristmasLights christmasLights = new ChristmasLights();
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("on", new int[]{0, 0}, new int[]{0, 0}));
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.isTurnedOn(0,0));
    }

    @Test
    void testTurningOnTheLights(){
        ChristmasLights christmasLights = new ChristmasLights();
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("on", new int[]{0, 0}, new int[]{999, 0}));
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.areOn(new int[]{0, 0}, new int[]{999, 0}));
    }
}
