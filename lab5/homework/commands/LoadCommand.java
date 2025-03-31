package org.example.homework.commands;

import org.example.compulsory.*;
import org.example.homework.Exceptions.InvalidRepositoryException;

public class LoadCommand implements Command {
    private final String path;

    public LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute(Repository repo, RepositoryService service) {
        try {
            Repository loadedRepo = service.load(path);
            repo.getImages().clear();
            repo.getImages().addAll(loadedRepo.getImages());
            System.out.println("Repository loaded from " + path);
        } catch (InvalidRepositoryException e) {
            System.err.println("Error loading repository: " + e.getMessage());
        }
    }
}
