package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    Location onEquator;
    Location onPrimeMeridian;

    @BeforeEach
    void setUp() {

        onEquator = new Location("Berlin", 0, 150);
        onPrimeMeridian = new Location("Benin", 150, 0);
    }


    @Test
    void isOnEquator() {

    assertTrue(onEquator.isOnEquator());
    assertFalse(onPrimeMeridian.isOnEquator());

    }

    @Test
    void isOnPrimeMeridian() {
        assertTrue(onPrimeMeridian.isOnPrimeMeridian());
        assertFalse(onEquator.isOnPrimeMeridian());
    }
}