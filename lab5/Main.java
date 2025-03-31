package org.example;

import org.example.compulsory.Repository;
import org.example.compulsory.RepositoryService;
import org.example.homework.commands.*;
import org.example.homework.Exceptions.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        RepositoryService service = new RepositoryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String[] input = scanner.nextLine().split(" ", 2);
            String command = input[0].toLowerCase();
            String argument = input.length > 1 ? input[1] : "";

            try {
                switch (command) {
                    case "add":
                        String[] parts = argument.split(" ", 2);
                        if (parts.length == 2) {
                            new AddCommand(parts[0], parts[1]).execute(repo, service);
                        } else {
                            throw new InvalidDataException("Usage: add <name> <path>");
                        }
                        break;
                    case "remove":
                        new RemoveCommand(argument).execute(repo, service);
                        break;
                    case "save":
                        new SaveCommand(argument).execute(repo, service);
                        break;
                    case "load":
                        new LoadCommand(argument).execute(repo, service);
                        break;
                    case "update":
                        String[] updateParts = argument.split(" ", 3);
                        if (updateParts.length == 3) {
                            new UpdateCommand(updateParts[0], updateParts[1], updateParts[2]).execute(repo, service);
                        } else {
                            throw new InvalidDataException("Usage: update <name> <field> <value>");
                        }
                        break;
                    case "report":
                        new ReportCommand(argument).execute(repo, service);
                        break;
                    case "exit":
                        System.out.println("Exiting...");
                        return;
                    default:
                        throw new InvalidCommandException("Unknown command: " + command);
                }
            } catch (InvalidCommandException | InvalidDataException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}