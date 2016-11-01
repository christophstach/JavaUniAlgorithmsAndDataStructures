package exercise.data;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class Student {
    private int mn;
    private String firstname;
    private String lastname;
    private Program program;

    public Student(int mn, String firstname, String lastname, Program program) {
        this.mn = mn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.program = program;
    }

    public int getMn() {
        return mn;
    }

    public void setMn(int mn) {
        this.mn = mn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", program=" + program +
            '}';
    }
}
