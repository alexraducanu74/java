package homework2;

import java.util.*;

/**
 * The {@code Person} class represents an individual with a name and date of birth.
 * It is an abstract class, meaning it cannot be instantiated directly and must be extended by other classes.
 * This class provides methods to get and set the name and date of birth of a person,
 * as well as overriding the {@code equals} and {@code toString} methods to compare and represent a person object.
 *
 * <p>Example usage:</p>
 * <pre>
 * Person person = new Person("John Doe", "01/01/2000");
 * System.out.println(person.getName()); // Output: John Doe
 * </pre>
 */
public abstract class Person {

    /**
     * The name of the person.
     */
    protected String name;

    /**
     * The date of birth of the person in string format.
     */
    protected String dateOfBirth;

    /**
     * Constructs a {@code Person} object with the specified name and date of birth.
     *
     * @param name The name of the person.
     * @param dateOfBirth The date of birth of the person.
     */
    public Person(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param dateOfBirth The new date of birth of the person.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the date of birth of the person.
     *
     * @return The date of birth of the person.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Compares this person to the specified object for equality.
     * Two persons are considered equal if they have the same name and date of birth.
     *
     * @param obj The object to compare this person against.
     * @return {@code true} if the specified object is equal to this person;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) && Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    /**
     * Returns a string representation of this person.
     * The string includes the person's name and date of birth.
     *
     * @return A string representation of the person in the format:
     *         "Person{name='name', dateOfBirth='dateOfBirth'}".
     */
    @Override
    public String toString() {
        return "Person{name='" + name + "', dateOfBirth='" + dateOfBirth + "'}";
    }
}
