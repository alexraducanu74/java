package org.example.homework;

import org.example.compulsory.LocationType;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.*;

import org.example.compulsory.Location;

public class Algorithm {
    private final org.example.homework.Problem problem;

    public Algorithm(org.example.homework.Problem problem) {
        this.problem = problem;
    }

    public Map<Location, Double> calculateShortestTimes() {
        DijkstraShortestPath<Location, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(problem.getGraph());
        Map<Location, Double> shortestTimes = new HashMap<>();
        Location startLocation = problem.getStartLocation();

        for (Location loc : problem.getLocations())
            shortestTimes.put(loc, dijkstra.getPathWeight(startLocation, loc));

        return shortestTimes;
    }

    public Map<LocationType, List<Location>> getCategorizedLocations() {
        Map<LocationType, List<Location>> categorizedLocations = new HashMap<>();
        for (Location location : problem.getLocations())
            if (!categorizedLocations.containsKey(location.getType()))
                categorizedLocations.put(location.getType(), new ArrayList<>());
        for (Location location : problem.getLocations())
            categorizedLocations.get(location.getType()).add(location);
        return categorizedLocations;
    }
}