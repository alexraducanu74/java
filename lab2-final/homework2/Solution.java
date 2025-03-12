package homework2;

import compulsory2.Student;
import compulsory2.Project;

/**
 * The {@code Solution} class provides a static method to allocate projects to students
 * based on their preferences. The allocation process ensures that students are assigned to
 * projects that are not yet allocated, with each student being assigned to their preferred project
 * (if available).
 *
 * <p>Example usage:</p>
 * <pre>
 * Problem problem = new Problem(students, teachers);
 * Solution.allocateProjects(problem);
 * </pre>
 */
public class Solution {

    /**
     * Allocates projects to students based on their preferences.
     * The method goes through each student and tries to assign them to one of their preferred projects
     * that has not been allocated yet. Once a student is assigned to a project, the project is marked as allocated.
     * The allocation results are printed to the console.
     *
     * @param p The {@code Problem} object containing the students and their preferences.
     *          It is assumed that students have a list of preferred projects and the projects are not yet allocated.
     */
    static public void allocateProjects(Problem p) {
        Student[] students = p.getStudents();
        for (Student student : students) {
            for (Project project : student.getPreferences()) {
                if (!project.isAllocated()) {
                    project.setAllocated(true);
                    System.out.println("Student " + student.getName() + " is assigned to project " + project.getName());
                    break;
                }
            }
        }
    }
}
