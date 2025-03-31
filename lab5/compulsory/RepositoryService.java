package org.example.compulsory;

import java.awt.*;
import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.homework.Exceptions.InvalidRepositoryException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class RepositoryService {
    public void save(Repository repo, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(new File(path), repo);
    }

    public Repository load(String path) throws InvalidRepositoryException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(new File(path), Repository.class);
        } catch (IOException e) {
            throw new InvalidRepositoryException(e);
        }
    }

    public void view(Image img) {
        if (img != null) {
            File file = new File(img.path());
            if (file.exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    System.err.println("Error opening image: " + e.getMessage());
                }
            } else {
                System.out.println("Image file not found: " + img.path());
            }
        } else {
            System.out.println("Image not found.");
        }
    }

    public void generateReport(Repository repo, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("<html><head><title>Image Repository Report</title></head><body>");
            writer.write("<h1>Image Repository</h1><ul>");
            for (Image img : repo.getImages()) {
                writer.write("<li>" + img.name() + " - " + img.date() + " - <a href=\"file://" + img.path() + "\">" + img.path() + "</a></li>");
            }
            writer.write("</ul></body></html>");
            writer.flush();
            Desktop.getDesktop().open(new File(outputPath));
        } catch (Exception e) {
            System.err.println("Error generating report: " + e.getMessage());
        }
    }
}