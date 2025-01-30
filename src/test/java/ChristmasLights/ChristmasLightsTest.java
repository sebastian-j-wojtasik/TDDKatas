package ChristmasLights;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChristmasLightsTest {
    @Test
    void areLightsOff(){
        ChristmasLights christmasLights = new ChristmasLights();
        boolean off = christmasLights.areAllOff();
        Assertions.assertTrue(off);
    }

}
