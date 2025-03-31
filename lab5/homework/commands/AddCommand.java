package org.example.homework.commands;

import org.example.compulsory.*;

import java.time.LocalDate;


public class AddCommand implements Command {
    private final String name;
    private final String path;

    public AddCommand(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public void execute(Repository repo, RepositoryService service) {
        repo.add(new Image(name, LocalDate.now(), path));
        System.out.println("Image added: " + name);
    }
}