package GossipingBusDrivers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GossipingTest {

    @Test
    void gossipingWithoutStops(){
        Gossiping gossiping = new Gossiping();
        List<List<Integer>> routs = new ArrayList<>();

        int stops = gossiping.gossip(routs);

        Assertions.assertEquals(0, stops);
    }

    @Test
    void gossipingWithTwoDriversOnOneStop(){
        Gossiping gossiping = new Gossiping();
        List<List<Integer>> routs = new ArrayList<>();
        routs.add(List.of(1));
        routs.add(List.of(1));

        int stops = gossiping.gossip(routs);

        Assertions.assertEquals(1,stops);
    }

}
