package homework2;

import java.util.*;
import compulsory2.Project;

/**
 * The {@code Teacher} class represents a teacher, which is a type of {@code Person}.
 * In addition to the basic attributes of a person (name and date of birth), a teacher has an array of proposed projects.
 * This class provides methods to get and set the proposed projects for the teacher and overrides the {@code toString} method
 * to include information about the teacher's proposed projects.
 *
 * <p>Example usage:</p>
 * <pre>
 * Project[] projects = { new Project("Project1"), new Project("Project2") };
 * Teacher teacher = new Teacher("Jane Doe", "10/10/1980", projects);
 * System.out.println(teacher.getProposedProjects()); // Output: [Project1, Project2]
 * </pre>
 */
public class Teacher extends Person {

    /**
     * The array of proposed projects for the teacher.
     */
    private Project[] proposedProjects;

    /**
     * Constructs a {@code Teacher} object with the specified name, date of birth, and proposed projects.
     *
     * @param name The name of the teacher.
     * @param dateOfBirth The date of birth of the teacher.
     * @param proposedProjects The array of proposed projects for the teacher.
     */
    public Teacher(String name, String dateOfBirth, Project[] proposedProjects) {
        super(name, dateOfBirth);
        this.proposedProjects = proposedProjects;
    }

    /**
     * Sets the proposed projects for the teacher.
     *
     * @param proposedProjects The new array of proposed projects.
     */
    public void setProposedProjects(Project[] proposedProjects) {
        this.proposedProjects = proposedProjects;
    }

    /**
     * Gets the proposed projects for the teacher.
     *
     * @return The array of proposed projects.
     */
    public Project[] getProposedProjects() {
        return proposedProjects;
    }

    /**
     * Returns a string representation of the teacher.
     * The string includes the teacher's name and the list of proposed projects.
     *
     * @return A string representation of the teacher in the format:
     *         "Teacher{name='name', proposedProjects=[project1, project2, ...]}".
     */
    @Override
    public String toString() {
        return "Teacher{name='" + name + "', proposedProjects=" + Arrays.toString(proposedProjects) + "}";
    }
}
