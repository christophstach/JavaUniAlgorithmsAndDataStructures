package exercise;

import exercise.data.Program;
import exercise.data.Student;
import exercise.lists.DoublyLinkedList;
import exercise.lists.Listable;
import exercise.lists.SinglyLinkedList;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class Application {
    /**
     * Haupt methode
     *
     * @param args commandline args
     */
    public static void main(String[] args) {
        Student s1 = new Student(1, "Christoph", "Stach", Program.APPLIED_COMPUTING);
        Student s2 = new Student(2, "Adrian", "Saiz Ferri", Program.APPLIED_COMPUTING);
        Student s3 = new Student(3, "Laila", "Westphal", Program.APPLIED_COMPUTING);
        Student s4 = new Student(4, "Steffen", "Exler", Program.APPLIED_COMPUTING);
        Student s5 = new Student(5, "Laura", "Hartgers", Program.APPLIED_COMPUTING);
        Student s6 = new Student(6, "Miles", "Lorenz", Program.APPLIED_COMPUTING);
        Student s7 = new Student(7, "Martin", "Johnki", Program.APPLIED_COMPUTING);

        //Listable<Student> list = new SinglyLinkedList<>();
        Listable<Student> list = new DoublyLinkedList<>();

        list.insertLast(s1);
        list.insertLast(s2);
        list.insertLast(s3);
        list.insertLast(s4);
        list.insertLast(s5);
        list.insertLast(s6);
        list.insert(2, s7);

        //list.insert(3, s4);
        //list.remove(0);


        list.printAll();

        int i = 6;
        i--;
        System.out.println("Size: " + list.getSize());
        System.out.println("s" + (i + 1) + ": " + list.get(i));
    }
}
