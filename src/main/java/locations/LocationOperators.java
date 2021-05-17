package locations;

import java.util.ArrayList;
import java.util.List;

public class LocationOperators {


    public List<Location> filterOnNorth(List<Location> locations) {
        List<Location> locationOnNorth = new ArrayList<>();
        for (Location item : locations
        ) {
            if (item.getLat() > 0) {
                locationOnNorth.add(item);
            }
        }
        return locationOnNorth;
    }

}
