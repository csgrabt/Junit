package locations;

import java.util.Arrays;

public class LocationParser {


    public static final String REGEX = ",";

    public Location parse(String text) {
        validator(text);

        try {
            String[] array = text.split(REGEX);

            return new Location(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]));

        } catch (NumberFormatException exp) {
            throw new IllegalArgumentException("Something went wrong", exp);
        }
    }

    private void validator(String text) {
        int counter = 0;
        for (Character item : text.toCharArray()
        ) {
            if (item.equals(',')) {
                counter++;
            }
        }
        if (counter != 2) {
            throw new IllegalArgumentException("Not valid input format!");
        }
    }
}
