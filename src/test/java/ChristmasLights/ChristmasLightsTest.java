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
}
