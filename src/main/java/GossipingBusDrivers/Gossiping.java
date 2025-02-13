package GossipingBusDrivers;
import java.util.*;

public class Gossiping {

    public int gossip(List<List<Integer>> routes) {
        if(!routes.isEmpty()){
            int drivers = routes.size();
            Set<Integer> gossiped = new HashSet<>();
            for (int minute = 1; minute <= 480; minute++) {
                Map<Integer, List<Integer>> gossipingDriverPerStop= new HashMap<>();
                for (int driver = 0; driver < drivers; driver++) {
                    int position = routes.get(driver).get((minute - 1) % routes.get(driver).size());
                    gossipingDriverPerStop.computeIfAbsent(position, k -> new ArrayList<>()).add(driver);
                }

                for (Map.Entry<Integer, List<Integer>> entry : gossipingDriverPerStop.entrySet()) {
                    List<Integer> driversOnStop = entry.getValue();
                    if(driversOnStop.size()>1){
                        gossiped.addAll(driversOnStop);
                    }
                }
                if( gossiped.size() == drivers){
                    return minute;
                }
            }
            return 0;
        }else {
            return 0;
        }
    }
}
