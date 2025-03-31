package org.example.homework.commands;

import org.example.compulsory.Repository;
import org.example.compulsory.RepositoryService;

import java.io.*;

public class SaveCommand implements Command {
    private final String path;

    public SaveCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute(Repository repo, RepositoryService service) {
        try {
            service.save(repo, path);
            System.out.println("Repository saved to " + path);
        } catch (IOException e) {
            System.err.println("Error saving repository: " + e.getMessage());
        }
    }
}