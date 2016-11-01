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
public class Main {
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

        Listable<Student> list = new SinglyLinkedList<>();
        //Listable<Student> list = new DoublyLinkedList<>();

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.insertAt(3, s4);
        //list.delete(1);


        list.printAll();
        System.out.println("Size: " + list.getSize());
        System.out.println("s1: " + list.get(0));
    }
}
