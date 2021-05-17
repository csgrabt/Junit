package locations;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationParserTest {

    @Test
    void testParseInputIsOk() {

        Location location = new LocationParser().parse("Budapest,45.12,45.13");

        assertEquals("Budapest", location.getName());
        assertEquals(45.12, location.getLat());
        assertEquals(45.13, location.getLon());

    }

    @Test
    void testInvalidInputNotANumber() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LocationParser().parse("Budapest,45.12,45.1n");
        });
        assertEquals("Something went wrong", ex.getMessage());
    }

    @Test
    void testInvalidTooMuchRegex() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new LocationParser().parse("Budapest,45.12,45.1n,56");
        });
        assertEquals("Not valid input format!", ex.getMessage());
    }

    @Test
    void testDifferentLocation() {
        String locationSting = "Budapest,150,150";
        LocationParser locationParser = new LocationParser();
        assertNotSame(locationParser.parse(locationSting), locationParser.parse(locationSting));
    }


    @Test
    void testDistance() {
        Location location1 = new Location("A", 35.6544, 139.74477, 0);
        Location location2 = new Location("B", 21.4225, 39.8261, 0);

        assertEquals(9491.28, location1.distance(location2), 0.005);
    }

    @Test
    void testAllGetter() {
        Location location = new LocationParser().parse("Budapest,0,150,250");

        assertEquals("Budapest", location.getName());
        assertEquals(0, location.getLat());
        assertEquals(150, location.getLon());
        assertEquals(250, location.getHeight());
    }
}