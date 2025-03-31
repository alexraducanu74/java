package org.example.homework.commands;

import org.example.compulsory.Repository;
import org.example.compulsory.*;

public class RemoveCommand implements Command {
    private final String name;

    public RemoveCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(Repository repo, RepositoryService service) {
        repo.remove(name);
        System.out.println("Image removed: " + name);
    }
}