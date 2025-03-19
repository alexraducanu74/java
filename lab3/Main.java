import java.util.*;
import compulsory.Airliner;
import compulsory.Freighter;
import compulsory.Drone;
import compulsory.Aircraft;
import compulsory.CargoCapable;
import homework.Airport;
import homework.Flight;
import homework.Algorithm1;
import bonus.Problem;
import bonus.Algorithm;
import bonus.Solution;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        //compulsory
        System.out.println("compulsory");
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

        System.out.println("homework");
        //homework +
        Airport airport = new Airport(2);
        List<Flight> flights = new ArrayList<>();

        Airliner airliner = new Airliner("a", "A123", 416);
        Freighter freighter = new Freighter("f", "F567", 50000);
        Drone drone = new Drone("d", "D999", 120, 645364);

        flights.add(new Flight("F1", airliner, LocalTime.of(10, 0), LocalTime.of(10, 30)));
        flights.add(new Flight("F2", freighter, LocalTime.of(10, 15), LocalTime.of(10, 45)));
        flights.add(new Flight("F3", drone, LocalTime.of(10, 40), LocalTime.of(11, 0)));
        flights.add(new Flight("F3", drone, LocalTime.of(10, 40), LocalTime.of(11, 0)));

        Problem problem = new Problem(airport, flights);
        Algorithm1 algorithm = new Algorithm1(problem);
        Solution solution = new Solution(algorithm);
        solution.printSolution();

        //bonus
        System.out.println("bonus");
        Algorithm algorithm2 = new Algorithm(problem);
        Solution solution2 = new Solution(algorithm2);
        solution2.printSolution();
    }
}
