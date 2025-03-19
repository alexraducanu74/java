package homework;

import java.util.List;
import java.util.ArrayList;

public class Airport {
    private final List<String> runways;

    public Airport(int runwayCount) {
        runways = new ArrayList<>();
        for (int i = 0; i < runwayCount; i++) {
            runways.add("Runway " + (i + 1));
        }
    }

    public List<String> getRunways() {
        return runways;
    }
}
