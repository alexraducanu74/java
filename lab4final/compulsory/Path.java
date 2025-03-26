package org.example.compulsory;

public class Path {
    private final Location start;
    private final Location end;
    private final int time;
    private final double safetyProbability;

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
