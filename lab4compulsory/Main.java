package org.example;

import java.util.*;
import java.util.stream.Collectors;
import org.example.compulsory.Location;
import org.example.compulsory.LocationType;
import org.example.compulsory.NeutralLocation;
import org.example.compulsory.EnemyLocation;
import org.example.compulsory.FriendlyLocation;
public class Main {
    public static void main(String[] args) {
        List<Location> locations = Arrays.asList(
                new FriendlyLocation("A"),
                new FriendlyLocation("B"),
                new EnemyLocation("C"),
                new EnemyLocation("D"),
                new NeutralLocation("E"),
                new FriendlyLocation("F"),
                new EnemyLocation("G")
        );


        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(loc -> loc.getType() == LocationType.FRIENDLY)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("friendly:");
        friendlyLocations.forEach(System.out::println);


        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> loc.getType() == LocationType.ENEMY)
                .sorted(Comparator.comparing(Location::getType)
                        .thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("enemy:");
        enemyLocations.forEach(System.out::println);
    }
}
