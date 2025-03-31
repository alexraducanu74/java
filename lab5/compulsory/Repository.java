package org.example.compulsory;

import java.util.*;
import java.util.List;

public class Repository {
    private final List<Image> images = new ArrayList<>();

    public Repository() {
    }

    public List<Image> getImages() {
        return images;
    }

    public void add(Image image) {
        images.add(image);
    }

    public void remove(String name) {
        images.removeIf(img -> img.name().equals(name));
    }

    public void update(String name, String newName, String newPath) {
        for (int i = 0; i < images.size(); i++) {
            Image img = images.get(i);
            if (Objects.equals(img.name(), name)) {
                images.set(i, new Image(newName != null ? newName : img.name(), img.date(), newPath != null ? newPath : img.path()));
                System.out.println("Updated: " + name + " -> " + newName);
                return;
            }
        }
        System.out.println("Image not found: " + name);
    }

    @Override
    public String toString() {
        return "Repository{" + "images=" + images + '}';
    }
}