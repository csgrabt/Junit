package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationOperatorsTest {
    List<Location> locationList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        locationList.add(new Location("Helsinki", 60, 56));
        locationList.add(new Location("canberra", -35, 149));
    }


    @Test
    void filterOnNorth() {

        assertEquals(1, new LocationOperators().filterOnNorth(locationList).size());
        assertEquals("Helsinki", new LocationOperators().filterOnNorth(locationList).get(0).getName());
    }
}