package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

import org.example.compulsory.Location;
import org.example.compulsory.LocationType;
import org.example.compulsory.NeutralLocation;
import org.example.compulsory.EnemyLocation;
import org.example.compulsory.FriendlyLocation;


import org.example.homework.Problem;
import org.example.homework.Algorithm;
import org.example.homework.Solution;

import org.example.bonus.Problemb;
import org.example.bonus.Algorithmb;
import org.example.bonus.Solutionb;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        List<Location> locations = Arrays.asList(
                new FriendlyLocation(faker),
                new FriendlyLocation(faker),
                new EnemyLocation(faker),
                new EnemyLocation(faker),
                new NeutralLocation(faker),
                new FriendlyLocation(faker),
                new EnemyLocation(faker)
        );


        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(loc -> loc.getType() == LocationType.FRIENDLY)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("compulsory");
        System.out.println("friendly:");
        friendlyLocations.forEach(System.out::println);


        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> loc.getType() == LocationType.ENEMY)
                .sorted(Comparator.comparing(Location::getType)
                        .thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("enemy:");
        enemyLocations.forEach(System.out::println);

        // homework
        System.out.println("\n");
        Problem problem = new Problem(locations);
        Algorithm algorithm = new Algorithm(problem);
        Solution solution = new Solution(algorithm);
        solution.printSolution();
        //bonus
        System.out.println("\n");
        Problemb problemb = new Problemb(locations);
        Algorithmb algorithmb = new Algorithmb(problemb);
        Solutionb solutionb = new Solutionb(algorithmb);
        solutionb.printSolution();
    }
}
