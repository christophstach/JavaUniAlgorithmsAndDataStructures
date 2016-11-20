package exercise.list;

import exercise.data.Gender;
import exercise.data.Program;
import exercise.data.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public abstract class ListableTest {
    protected Listable<Student> list;
    protected Student[] testStudents;

    @Before
    public void setUp() {
        this.testStudents = new Student[]{
            new Student(0, "Christoph", "Stach", Program.APPLIED_COMPUTING, Gender.MALE),
            new Student(1, "Adrianz", "Saiz Ferri", Program.APPLIED_COMPUTING, Gender.MALE),
            new Student(2, "Laila", " Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE),
            new Student(3, "Laura", "Hartgers", Program.APPLIED_COMPUTING, Gender.FEMALE),
            new Student(4, "Martin", "Johnki", Program.APPLIED_COMPUTING, Gender.MALE),
            new Student(5, "Miles", "Lorenz", Program.APPLIED_COMPUTING, Gender.MALE),
        };
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.list.empty());
        this.list.insertLast(this.testStudents[0]);
        Assert.assertFalse(this.list.empty());
    }

    @Test
    public void clearAll() {
        this.list.insertLast(this.testStudents[0]);
        Assert.assertFalse(this.list.empty());
        this.list.clearAll();
        Assert.assertTrue(this.list.empty());
    }

    @Test
    public void getSize() {
        Assert.assertEquals(0, this.list.size());
        this.list.insertLast(this.testStudents[0]);
        Assert.assertEquals(1, this.list.size());
        this.list.insertLast(this.testStudents[1]);
        Assert.assertEquals(2, this.list.size());
    }

    @Test
    public void insert() {
        this.list.insert(0, this.testStudents[0]);
        this.list.insert(1, this.testStudents[1]);

        Assert.assertEquals(2, this.list.size());
        Assert.assertSame(this.testStudents[0], this.list.get(0));
        Assert.assertSame(this.testStudents[1], this.list.get(1));

        this.list.insert(1, this.testStudents[2]);
        Assert.assertSame(this.testStudents[2], this.list.get(1));
        Assert.assertSame(this.testStudents[1], this.list.get(2));

        this.list.insert(2, this.testStudents[3]);
        Assert.assertSame(this.testStudents[3], this.list.get(2));
    }

    @Test
    public void insertFirst() {
        this.list.insertFirst(this.testStudents[0]);
        this.list.insertFirst(this.testStudents[1]);
        this.list.insertFirst(this.testStudents[2]);
        this.list.insertFirst(this.testStudents[3]);

        Assert.assertEquals(4, this.list.size());
        Assert.assertSame(this.testStudents[3], this.list.get(0));
        Assert.assertSame(this.testStudents[0], this.list.get(3));
    }

    @Test
    public void insertLast() {
        this.list.insertLast(this.testStudents[0]);
        this.list.insertLast(this.testStudents[1]);
        this.list.insertLast(this.testStudents[2]);
        this.list.insertLast(this.testStudents[3]);

        Assert.assertEquals(4, this.list.size());
        Assert.assertSame(this.testStudents[0], this.list.get(0));
        Assert.assertSame(this.testStudents[3], this.list.get(3));
    }

    @Test
    public void remove() {
        this.list.insertLast(this.testStudents[0]);
        this.list.insertLast(this.testStudents[1]);
        this.list.insertLast(this.testStudents[2]);
        this.list.insertLast(this.testStudents[3]);
        this.list.insertLast(this.testStudents[4]);
        this.list.insertLast(this.testStudents[5]);
        Assert.assertEquals(6, this.list.size());

        this.list.remove(0);
        Assert.assertEquals(5, this.list.size());
        Assert.assertSame(this.testStudents[1], this.list.get(0));
        this.list.insertFirst(this.testStudents[0]);

        this.list.remove(5);
        Assert.assertEquals(5, this.list.size());
        Assert.assertSame(this.testStudents[4], this.list.get(4));
        this.list.insertLast(this.testStudents[5]);

        this.list.remove(1);
        Assert.assertEquals(5, this.list.size());
        Assert.assertSame(this.testStudents[2], this.list.get(1));
        this.list.insert(1, this.testStudents[1]);

        this.list.remove(4);
        Assert.assertEquals(5, this.list.size());
        Assert.assertSame(this.testStudents[5], this.list.get(4));
    }

    @Test
    public void get() {
        this.list.insertFirst(this.testStudents[0]);
        this.list.insertLast(this.testStudents[1]);

        Assert.assertSame(this.testStudents[0], this.list.get(0));
        Assert.assertSame(this.testStudents[1], this.list.get(1));
    }


    @Test(expected = IllegalArgumentException.class)
    public void getThrowsIllegalArgumentException() {
        this.list.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertThrowsIllegalArgumentException() {
        this.list.insert(1, this.testStudents[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeThrowsIllegalArgumentException() {
        this.list.remove(1);
    }
}
