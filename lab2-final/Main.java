

import java.util.*;
import compulsory2.ProjectType;
import compulsory2.Project;
import compulsory2.Student;
import homework2.Problem;
import homework2.Teacher;
import homework2.Solution;

public class Main {
    public static void main(String[] args) {

        // compulsory
        System.out.println("compulsory");
        Project p1 = new Project("p1", ProjectType.THEORETICAL);
        Project p2 = new Project("p2", ProjectType.PRACTICAL);
        Project[] preferredProjects = {p1, p2};

        Student s1 = new Student("abc","03-01-2003", 100, preferredProjects);
        String projectRepresentation = p1.toString();
        String studentRepresentation = s1.toString();
        System.out.println(projectRepresentation);
        System.out.println(studentRepresentation);

        //homework
        System.out.println("homework");
        Project p11 = new Project("p1", ProjectType.THEORETICAL);
        Project p22 = new Project("p2", ProjectType.PRACTICAL);
        Project p33 = new Project("p3", ProjectType.PRACTICAL);
        Project[] projects1 = {p11, p22};
        Project[] projects2 = {p22, p33};

        Student s11 = new Student("A", "15.05.2000", 123, projects1);
        Student s22 = new Student("B", "20.11.2003", 124, projects2);
        Student[] students = {s11, s22};

        Teacher t1 = new Teacher("T", "1975-04-10", projects1);
        Teacher[] teachers = {t1};

        Problem problem = new Problem(students, teachers);
        System.out.println(Arrays.toString(problem.getAllPersons()));
        Solution.allocateProjects(problem);
    }
}
