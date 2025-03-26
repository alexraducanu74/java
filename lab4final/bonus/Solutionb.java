package org.example.bonus;

import java.util.*;

import org.example.compulsory.Location;
import org.example.compulsory.LocationType;

public class Solutionb {
    private final Algorithmb algorithm;

    public Solutionb(Algorithmb algorithm) {
        this.algorithm = algorithm;
    }

    public void printSolution() {
        Map<Location, Double> shortestTimes = algorithm.calculateSafestTimes();

        System.out.println("bonus:");
        System.out.println("fastest travel times:");

        for (LocationType type : LocationType.values()) {
            if (type == LocationType.FRIENDLY) {
                System.out.println(type + " locations:");
                List<Location> locationsForType = algorithm.getCategorizedLocations().get(type);

                for (Location loc : locationsForType)
                    System.out.println(loc.getName() + " safety score -> " + (shortestTimes.get(loc)) + " (lower is better)");
            }
        }
        for (LocationType type : LocationType.values()) {
            if (type == LocationType.NEUTRAL) {
                System.out.println(type + " locations:");
                List<Location> locationsForType = algorithm.getCategorizedLocations().get(type);

                for (Location loc : locationsForType)
                    System.out.println(loc.getName() + " safety score -> " + (shortestTimes.get(loc)) + " (lower is better)");
            }
        }
        for (LocationType type : LocationType.values()) {
            if (type == LocationType.ENEMY) {
                System.out.println(type + " locations:");
                List<Location> locationsForType = algorithm.getCategorizedLocations().get(type);

                for (Location loc : locationsForType)
                    System.out.println(loc.getName() + " safety score -> " + (shortestTimes.get(loc)) + " (lower is better)");
            }
        }
    }
}