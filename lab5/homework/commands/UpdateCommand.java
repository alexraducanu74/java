package org.example.homework.commands;

import org.example.compulsory.*;

public class UpdateCommand implements Command {
    private final String name;
    private final String newName;
    private final String newPath;

    public UpdateCommand(String name, String newName, String newPath) {
        this.name = name;
        this.newName = newName;
        this.newPath = newPath;
    }

    @Override
    public void execute(Repository repo, RepositoryService service) {
        repo.update(name, newName, newPath);
    }
}
