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
}