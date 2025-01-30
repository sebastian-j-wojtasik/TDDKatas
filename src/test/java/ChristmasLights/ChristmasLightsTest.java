package ChristmasLights;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChristmasLightsTest {
    @Test
    void areLightsOffWithNoInstruction(){
        ChristmasLights christmasLights = new ChristmasLights();
        Map<String, Integer[]> instructions = new HashMap<>();
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.areAllOff());
    }

    @Test
    void testTurningOnTheLight(){
        ChristmasLights christmasLights = new ChristmasLights();
        Map<String, Integer[]> instructions = new HashMap<>();
        instructions.put("On", new Integer[]{0,0});
        christmasLights.configure(instructions);
        Assertions.assertTrue(christmasLights.isTurnedOn(0,0));
    }
}
