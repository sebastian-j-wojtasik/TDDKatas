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

    @Test
    void testToggleTheLights(){
        ChristmasLights christmasLights = new ChristmasLights();
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("on", new int[]{0, 0}, new int[]{0, 500}));
        instructions.add(new Instruction("toggle", new int[]{0, 0}, new int[]{0, 999}));
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.areOff(new int[]{0, 0}, new int[]{0, 500}));
        Assertions.assertTrue(christmasLights.areOn(new int[]{0, 501}, new int[]{0, 999}));
    }

    @Test
    void testTurnOffTheLights(){
        ChristmasLights christmasLights = new ChristmasLights();
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("on", new int[]{0, 0}, new int[]{0, 500}));
        instructions.add(new Instruction("off", new int[]{0, 0}, new int[]{0, 500}));
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.areOff(new int[]{0, 0}, new int[]{0, 500}));
    }

    @Test
    void testAllGivenInstructions(){
        ChristmasLights christmasLights = new ChristmasLights();
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("on", new int[]{887,9}, new int[]{959,629}));
        instructions.add(new Instruction("on", new int[]{454,398}, new int[]{844,448}));
        instructions.add(new Instruction("off", new int[]{539,243}, new int[]{559,965}));
        instructions.add(new Instruction("off", new int[]{370,819}, new int[]{676,868}));
        instructions.add(new Instruction("off", new int[]{145,40}, new int[]{370,997}));
        instructions.add(new Instruction("off", new int[]{301,3}, new int[]{808,453}));
        instructions.add(new Instruction("on", new int[]{351,678}, new int[]{951,908}));
        instructions.add(new Instruction("toggle", new int[]{720,196}, new int[]{897,994}));
        instructions.add(new Instruction("toggle", new int[]{831,394}, new int[]{904,860}));
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.isThisAmountOn(230022));
    }
}
