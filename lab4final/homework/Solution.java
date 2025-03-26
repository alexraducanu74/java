package org.example.homework;

import java.util.*;

import org.example.compulsory.Location;
import org.example.compulsory.LocationType;

public class Solution {
    private final org.example.homework.Algorithm algorithm;

    public Solution(org.example.homework.Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void printSolution() {
        Map<Location, Double> shortestTimes = algorithm.calculateShortestTimes();
        System.out.println("homework:");
        System.out.println("fastest travel times:");

        for (LocationType type : LocationType.values()) {
            if (type == LocationType.FRIENDLY) {
                System.out.println(type + " locations:");
                List<Location> locationsForType = algorithm.getCategorizedLocations().get(type);

                for (Location loc : locationsForType)
                    System.out.println(loc.getName() + " -> time: " + shortestTimes.get(loc) + " mins");
            }
        }
        for (LocationType type : LocationType.values()) {
            if (type == LocationType.NEUTRAL) {
                System.out.println(type + " locations:");
                List<Location> locationsForType = algorithm.getCategorizedLocations().get(type);

                for (Location loc : locationsForType)
                    System.out.println(loc.getName() + " -> time: " + shortestTimes.get(loc) + " mins");
            }
        }
        for (LocationType type : LocationType.values()) {
            if (type == LocationType.ENEMY) {
                System.out.println(type + " locations:");
                List<Location> locationsForType = algorithm.getCategorizedLocations().get(type);

                for (Location loc : locationsForType)
                    System.out.println(loc.getName() + " -> time: " + shortestTimes.get(loc) + " mins");
            }
        }
    }
}