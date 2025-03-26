package org.example.compulsory;

import com.github.javafaker.Faker;

abstract public class Location implements Comparable<Location> {
    protected String name;
    protected LocationType type;

    public Location(LocationType type, Faker faker) {
        this.name = faker.funnyName().name();
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return type + ": " + name;
    }
}
