package exercise.data;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class Student {
    private int mn;
    private String firstName;
    private String lastName;
    private Program program;

    public Student(int mn, String firstName, String lastName, Program program) {
        this.mn = mn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
    }

    public int getMn() {
        return mn;
    }

    public void setMn(int mn) {
        this.mn = mn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student{" +
            "mn=" + mn +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", program=" + program +
            '}';
    }
}
