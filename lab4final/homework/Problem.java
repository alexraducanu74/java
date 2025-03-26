package org.example.homework;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;

import org.example.compulsory.Location;

public class Problem {
    private final List<Location> locations;
    private final SimpleWeightedGraph<Location, DefaultWeightedEdge> graph;


    public Problem(List<Location> locations) {
        this.locations = locations;
        this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        initializeGraph();
    }

    private void initializeGraph() {
        locations.forEach(graph::addVertex);

        Random rand = new Random();
        for (int i = 0; i < locations.size(); i++)
            for (int j = i + 1; j < locations.size(); j++)
                if (rand.nextBoolean()) {
                    graph.addEdge(locations.get(i), locations.get(j));
                    graph.setEdgeWeight(locations.get(i), locations.get(j), rand.nextInt(20) + 1);
                }
    }

    public List<Location> getLocations() {
        return locations;
    }

    public SimpleWeightedGraph<Location, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public Location getStartLocation() {
        return locations.getFirst();
    }
}