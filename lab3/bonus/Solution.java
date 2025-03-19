package bonus;

import bonus.Algorithm;
import homework.Flight;
import homework.Algorithm1;

import java.util.*;

public class Solution {
    private Algorithm algorithm;
    private Algorithm1 algorithm1;
    private Map<Flight, String> result;

    public Solution(Algorithm algorithm) {
        this.algorithm = algorithm;
        this.result = algorithm.solve();
    }

    public Solution(Algorithm1 algorithm) {
        this.algorithm1 = algorithm;
        this.result = algorithm1.solve();
    }

    public void printSolution() {
        result.forEach((flight, runway) ->
                System.out.println("Flight " + flight.getFlightId() + " assigned to " + runway));
    }
}
