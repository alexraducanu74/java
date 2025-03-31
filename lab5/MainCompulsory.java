package org.example;

import org.example.compulsory.Repository;
import org.example.compulsory.RepositoryService;
import org.example.compulsory.Image;

import java.time.LocalDate;

import org.example.homework.Exceptions.InvalidRepositoryException;

import java.io.*;

public class MainCompulsory {
    public static void main(String[] args) {
        MainCompulsory app = new MainCompulsory();
        app.testRepo();
    }

    private void testRepo() {
        var repo = new Repository(); // Model
        repo.add(new Image("Duke", LocalDate.of(2005, 1, 1), "C:\\Users\\Administrator\\Downloads\\Estus_Flask_29_-_01.png"));
        repo.add(new Image("Java Logo", LocalDate.now(), "C:\\Users\\Administrator\\Downloads\\lfac.png"));
        System.out.println(repo);

        var service = new RepositoryService(); // Logic
        try {
            service.save(repo, "C:\\Users\\Administrator\\Downloads\\repo.json");
            var repo2 = service.load("C:\\Users\\Administrator\\Downloads\\repo.json"); // or .json, .xml, .ser, ...
            service.view(repo2.getImages().getFirst());
            repo2.add(new Image("Sample", LocalDate.now(), "C:\\Users\\Administrator\\Downloads\\lfac.png"));
            service.save(repo2, "C:\\Users\\Administrator\\Downloads\\repo.json");
        } catch (InvalidRepositoryException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
