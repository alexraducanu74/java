package org.example.homework.commands;

import org.example.compulsory.*;

public interface Command {
    void execute(Repository repo, RepositoryService service);
}