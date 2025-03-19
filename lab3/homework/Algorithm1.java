package homework;

import bonus.Problem;
import homework.Flight;

import java.time.LocalTime;
import java.util.*;

public class Algorithm1 {
    private Problem problem;

    public Algorithm1(Problem problem) {
        this.problem = problem;
    }

    public Map<Flight, String> solve() {
        List<String> runways = problem.getAirport().getRunways();
        Map<Flight, String> schedule = new HashMap<>();
        Map<String, List<Flight>> assignedFlights = new HashMap<>();
        for (String runway : runways) assignedFlights.put(runway, new ArrayList<>());

        for (Flight flight : problem.getFlights()) {
            for (String runway : runways) {
                boolean conflict = false;
                for (Flight f : assignedFlights.get(runway)) {
                    if (f.getLandingInterval().conflictsWith(flight.getLandingInterval())) {
                        conflict = true;
                        break;
                    }
                }
                if (!conflict) {
                    schedule.put(flight, runway);
                    assignedFlights.get(runway).add(flight);
                    break;
                }
            }
        }
        return schedule;
    }
}