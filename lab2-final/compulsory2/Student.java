package compulsory2;

import java.util.*;
import homework2.Person;

/**
 * The {@code Student} class represents a student, which is a type of {@code Person}.
 * In addition to the basic attributes of a person (name and date of birth), a student has
 * a registration number and a list of project preferences.
 * This class provides methods to get and set the student's registration number, preferences,
 * and a string representation of the student.
 *
 * <p>Example usage:</p>
 * <pre>
 * Project[] projects = { new Project("Project1", ProjectType.RESEARCH), new Project("Project2", ProjectType.DEVELOPMENT) };
 * Student student = new Student("John Doe", "01/01/2000", 12345, projects);
 * System.out.println(student.getRegistrationNumber()); // Output: 12345
 * System.out.println(student.getPreferences()); // Output: [Project1, Project2]
 * </pre>
 */
public class Student extends Person {

    /**
     * The registration number of the student.
     */
    private int registrationNumber;

    /**
     * The array of projects preferred by the student.
     */
    private Project[] preferences;

    /**
     * Constructs a {@code Student} object with the specified name, date of birth, registration number,
     * and project preferences.
     *
     * @param name The name of the student.
     * @param dateOfBirth The date of birth of the student.
     * @param registrationNumber The registration number of the student.
     * @param preferences The array of project preferences for the student.
     */
    public Student(String name, String dateOfBirth, int registrationNumber, Project[] preferences) {
        super(name, dateOfBirth);
        this.registrationNumber = registrationNumber;
        this.preferences = preferences;
    }

    /**
     * Sets the registration number of the student.
     *
     * @param registrationNumber The new registration number of the student.
     */
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Sets the preferences (project list) for the student.
     *
     * @param preferences The new array of project preferences.
     */
    public void setPreferences(Project[] preferences) {
        this.preferences = preferences;
    }

    /**
     * Gets the registration number of the student.
     *
     * @return The registration number of the student.
     */
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Gets the preferences (project list) for the student.
     *
     * @return The array of projects preferred by the student.
     */
    public Project[] getPreferences() {
        return preferences;
    }

    /**
     * Returns a string representation of the student.
     * The string includes the student's name, registration number, and preferences.
     *
     * @return A string representation of the student in the format:
     *         "Student{name='name', registrationNumber=registrationNumber, preferences=[project1, project2, ...]}".
     */
    @Override
    public String toString() {
        return "Student{name='" + name + "', registrationNumber=" + registrationNumber + ", preferences=" + Arrays.toString(preferences) + "}";
    }
}
