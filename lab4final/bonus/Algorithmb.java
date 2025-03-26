package org.example.bonus;

import org.example.compulsory.LocationType;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;

import org.example.compulsory.Location;

public class Algorithmb {
    private final Problemb problem;

    public Algorithmb(Problemb problem) {
        this.problem = problem;
    }

    public Map<Location, Double> calculateSafestTimes() {
        SimpleWeightedGraph<Location, DefaultWeightedEdge> modifiedGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (Location loc : problem.getLocations())
            modifiedGraph.addVertex(loc);

        for (DefaultWeightedEdge edge : problem.getGraph().edgeSet()) {
            Location source = problem.getGraph().getEdgeSource(edge);
            Location target = problem.getGraph().getEdgeTarget(edge);
            double transformedWeight = 1.0 - problem.getGraph().getEdgeWeight(edge);

            modifiedGraph.addEdge(source, target);
            modifiedGraph.setEdgeWeight(source, target, transformedWeight);
        }

        DijkstraShortestPath<Location, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(modifiedGraph);
        Map<Location, Double> safestTimes = new HashMap<>();
        Location startLocation = problem.getStartLocation();

        for (Location loc : problem.getLocations())
            safestTimes.put(loc, dijkstra.getPathWeight(startLocation, loc));

        return safestTimes;
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