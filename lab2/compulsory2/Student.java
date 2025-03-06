package compulsory2;

import java.util.*;

public class Student {
    private String name;
    private List<Project> preferences;

    public Student(String name, List<Project> preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Project> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", preferences=" + preferences +
                '}';
    }
}
