package org.example.compulsory;

public class Path {
    private Location start;
    private Location end;
    private int time;
    private double safetyProbability;

    public Path(Location start, Location end, int time, double safetyProbability) {
        this.start = start;
        this.end = end;
        this.time = time;
        this.safetyProbability = safetyProbability;
    }

    public int getTime() {
        return time;
    }

    public double getSafetyProbability() {
        return safetyProbability;
    }

    @Override
    public String toString() {
        return start.getName() + " -> " + end.getName() +
                " | Time: " + time + " mins | Safety: " + safetyProbability;
    }
}
