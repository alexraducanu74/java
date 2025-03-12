package homework2;

import java.util.Arrays;
import compulsory2.Student;

/**
 * The {@code Problem} class represents a problem that involves a collection of {@code Student} and {@code Teacher} objects.
 * It allows the management of students and teachers, ensuring that only distinct students and teachers are stored.
 * The class provides methods to retrieve the students, teachers, and all persons (both students and teachers).
 *
 * <p>Example usage:</p>
 * <pre>
 * Student[] students = { new Student("Student1"), new Student("Student2") };
 * Teacher[] teachers = { new Teacher("Teacher1", "01/01/1970", null), new Teacher("Teacher2", "02/02/1975", null) };
 * Problem problem = new Problem(students, teachers);
 * System.out.println(problem.getAllPersons()); // Output: [Student1, Student2, Teacher1, Teacher2]
 * </pre>
 */
public class Problem {

    /**
     * The array of distinct students involved in this problem.
     */
    private Student[] students;

    /**
     * The array of distinct teachers involved in this problem.
     */
    private Teacher[] teachers;

    /**
     * Constructs a {@code Problem} with the specified array of students and teachers.
     * The students and teachers arrays are filtered to contain only distinct entries.
     *
     * @param students The array of students involved in the problem.
     * @param teachers The array of teachers involved in the problem.
     */
    public Problem(Student[] students, Teacher[] teachers) {
        this.students = getDistinctStudents(students);
        this.teachers = getDistinctTeachers(teachers);
    }

    /**
     * Sets the students for this problem.
     *
     * @param students The new array of students.
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * Sets the teachers for this problem.
     *
     * @param teachers The new array of teachers.
     */
    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    /**
     * Gets the students involved in this problem.
     *
     * @return The array of distinct students.
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * Gets the teachers involved in this problem.
     *
     * @return The array of distinct teachers.
     */
    public Teacher[] getTeachers() {
        return teachers;
    }

    /**
     * Gets all persons (students and teachers) involved in this problem.
     * The result is an array containing both students and teachers.
     *
     * @return The array of {@code Person} objects, including both students and teachers.
     */
    public Person[] getAllPersons() {
        Person[] persons = new Person[students.length + teachers.length];
        System.arraycopy(students, 0, persons, 0, students.length);
        System.arraycopy(teachers, 0, persons, students.length, teachers.length);
        return persons;
    }

    /**
     * Filters the given array of students to remove any duplicates.
     *
     * @param students The array of students to filter.
     * @return An array of distinct students.
     */
    private Student[] getDistinctStudents(Student[] students) {
        Student[] distinctStudents = new Student[students.length];
        int index = 0;

        for (Student student : students) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (student.equals(distinctStudents[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                distinctStudents[index++] = student;
            }
        }

        return Arrays.copyOf(distinctStudents, index);
    }

    /**
     * Filters the given array of teachers to remove any duplicates.
     *
     * @param teachers The array of teachers to filter.
     * @return An array of distinct teachers.
     */
    private Teacher[] getDistinctTeachers(Teacher[] teachers) {
        Teacher[] distinctTeachers = new Teacher[teachers.length];
        int index = 0;

        for (Teacher teacher : teachers) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (teacher.equals(distinctTeachers[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                distinctTeachers[index++] = teacher;
            }
        }
        return Arrays.copyOf(distinctTeachers, index);
    }

    /**
     * Returns a string representation of the problem, including the list of students and teachers.
     *
     * @return A string representation of the problem in the format:
     *         "Problem{students=[student1, student2, ...], teachers=[teacher1, teacher2, ...]}".
     */
    @Override
    public String toString() {
        return "Problem{students=" + Arrays.toString(students) + ", teachers=" + Arrays.toString(teachers) + "}";
    }
}
