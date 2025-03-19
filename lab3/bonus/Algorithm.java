package bonus;

import bonus.Problem;
import homework.Flight;

import java.time.LocalTime;
import java.util.*;

public class Algorithm {
    private Problem problem;

    public Algorithm(Problem problem) {
        this.problem = problem;
    }

    public Map<Flight, String> solve() {
        List<Flight> unassignedFlights = new ArrayList<>();
        Map<String, List<Flight>> assignedFlights = new HashMap<>();
        List<String> runways = problem.getAirport().getRunways();
        Map<Flight, String> schedule = new HashMap<>();
        for (String runway : runways) assignedFlights.put(runway, new ArrayList<>());

        for (Flight flight : problem.getFlights()) {
            boolean assigned = false;
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
                    assigned = true;
                    break;
                }
            }

            if (!assigned)
                unassignedFlights.add(flight);
        }

        if (unassignedFlights.isEmpty()) {
            int minFlights = Integer.MAX_VALUE;
            int maxFlights = Integer.MIN_VALUE;

            for (String runway : runways) {
                int flightCount = assignedFlights.get(runway).size();
                minFlights = Math.min(minFlights, flightCount);
                maxFlights = Math.max(maxFlights, flightCount);
            }

            System.out.println("Runway balance: min=" + minFlights + ", max=" + maxFlights);

            if (maxFlights - minFlights <= 1)
                System.out.println("Runways are balanced (difference ≤ 1)");
            else
                System.out.println("Runways are not perfectly balanced, but all flights are assigned");
            for (String runway : runways)
                System.out.println(runway + ": " + assignedFlights.get(runway).size() + " flights");
        } else
            System.out.println("Additional runways needed: " + computeAdditionalRunways(unassignedFlights));

        return schedule;
    }

    private int computeAdditionalRunways(List<Flight> unassignedFlights) {
        unassignedFlights.sort(Comparator.comparing(flight -> flight.getLandingInterval().getFirst()));
        List<LocalTime> runwayEndTimes = new ArrayList<>();

        for (Flight flight : unassignedFlights) {
            LocalTime startTime = flight.getLandingInterval().getFirst();
            LocalTime endTime = flight.getLandingInterval().getSecond();

            boolean assigned = false;

            for (int i = 0; i < runwayEndTimes.size(); i++) {
                if (startTime.isAfter(runwayEndTimes.get(i)) || startTime.equals(runwayEndTimes.get(i))) {
                    runwayEndTimes.set(i, endTime);
                    assigned = true;
                    break;
                }
            }
            if (!assigned)
                runwayEndTimes.add(endTime);
        }
        return runwayEndTimes.size();
    }
}