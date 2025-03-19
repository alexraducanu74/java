package bonus;

import homework.Airport;
import homework.Flight;

import java.util.*;

public class Problem {
    private List<Flight> flights;
    private Airport airport;

    public Problem(Airport airport, List<Flight> flights) {
        this.airport = airport;
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public Airport getAirport() {
        return airport;
    }
}