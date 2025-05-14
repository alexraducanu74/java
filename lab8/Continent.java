package org.example;

public class Continent extends AbstractEntity {
    private final String name;
    public Continent(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() { return name; }
}