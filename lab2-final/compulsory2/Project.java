package compulsory2;

import java.util.*;

/**
 * The {@code Project} class represents a project with a name, a type, and an allocation status.
 * A project can be of different types (e.g., {@code ProjectType}) and can be marked as allocated or not.
 * This class provides methods to set and get the project's name, type, and allocation status,
 * as well as to compare and represent the project as a string.
 *
 * <p>Example usage:</p>
 * <pre>
 * Project project = new Project("AI Research", ProjectType.RESEARCH);
 * System.out.println(project.getName()); // Output: AI Research
 * project.setAllocated(true);
 * System.out.println(project.isAllocated()); // Output: true
 * </pre>
 */
public class Project {

    /**
     * The name of the project.
     */
    private String name;

    /**
     * The type of the project (e.g., RESEARCH, DEVELOPMENT).
     */
    private ProjectType type;

    /**
     * The allocation status of the project, indicating whether it has been allocated.
     * Initially set to {@code false} (not allocated).
     */
    private boolean allocated;

    /**
     * Constructs a {@code Project} with the specified name and type.
     * The project is initially not allocated.
     *
     * @param name The name of the project.
     * @param type The type of the project (e.g., RESEARCH, DEVELOPMENT).
     */
    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
        this.allocated = false;
    }

    /**
     * Sets the type of the project.
     *
     * @param type The new type of the project.
     */
    public void setType(ProjectType type) {
        this.type = type;
    }

    /**
     * Sets the name of the project.
     *
     * @param name The new name of the project.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the project.
     *
     * @return The name of the project.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of the project.
     *
     * @return The type of the project.
     */
    public ProjectType getType() {
        return type;
    }

    /**
     * Checks whether the project has been allocated.
     *
     * @return {@code true} if the project is allocated, {@code false} otherwise.
     */
    public boolean isAllocated() {
        return allocated;
    }

    /**
     * Sets the allocation status of the project.
     *
     * @param a The new allocation status: {@code true} if allocated, {@code false} otherwise.
     */
    public void setAllocated(boolean a) {
        allocated = a;
    }

    /**
     * Compares this project to the specified object for equality.
     * Two projects are considered equal if they have the same name and type.
     *
     * @param obj The object to compare this project against.
     * @return {@code true} if the specified object is equal to this project;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project project = (Project) obj;
        return Objects.equals(name, project.name) && type == project.type;
    }

    /**
     * Returns a string representation of this project.
     * The string includes the project's name and type.
     *
     * @return A string representation of the project in the format:
     *         "Project{name='name', type=type}".
     */
    @Override
    public String toString() {
        return "Project{name='" + name + "', type=" + type + "}";
    }
}
