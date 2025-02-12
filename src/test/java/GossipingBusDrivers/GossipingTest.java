package GossipingBusDrivers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GossipingTest {

    @Test
    void gossipingWithoutStops(){
        Gossiping gossiping = new Gossiping();

        int stops = gossiping.gossip();

        Assertions.assertEquals(0, stops);
    }
}
