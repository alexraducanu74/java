package compulsory3;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Airliner a1 = new Airliner("aaa", "123", 300);
        Airliner a2 = new Airliner("aaaaaa", "1234", 301);
        Freighter f1 = new Freighter("fffff", "22", 3121);
        Freighter f2 = new Freighter("ffffff", "222", 312121);
        Drone d1 = new Drone("ddd", "333", 100, 3112);
        Drone d2 = new Drone("dddd", "3334", 90, 312);

        List<Aircraft> aircraftList = Arrays.asList(a1, a2, f1, f2, d1, d2);

        List<CargoCapable> cargoAircraft = new ArrayList<>();
        for (Aircraft aircraft : aircraftList)
            if (aircraft instanceof CargoCapable)
                cargoAircraft.add((CargoCapable) aircraft);
        for (CargoCapable cargo : cargoAircraft)
            System.out.println(cargo);
    }
}
