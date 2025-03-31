package org.example.homework.commands;

import org.example.compulsory.*;

public class ReportCommand implements Command {
    private final String path;

    public ReportCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute(Repository repo, RepositoryService service) {
        service.generateReport(repo, path);
    }
}
