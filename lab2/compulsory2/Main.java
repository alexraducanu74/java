package compulsory2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Project p1 = new Project("p1", ProjectType.THEORETICAL);
        Project p2 = new Project("p2", ProjectType.PRACTICAL);
        List<Project> preferredProjects = new ArrayList<>();
        preferredProjects.add(p1);
        preferredProjects.add(p2);
        Student s1 = new Student("abc", preferredProjects);
        String projectRepresentation = p1.toString();
        String studentRepresentation = s1.toString();
        System.out.println(projectRepresentation);
        System.out.println(studentRepresentation);
    }
}