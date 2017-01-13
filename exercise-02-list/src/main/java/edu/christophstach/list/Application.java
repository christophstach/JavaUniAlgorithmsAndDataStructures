package edu.christophstach.list;

import edu.christophstach.list.comparator.Comparable;
import edu.christophstach.list.comparator.*;
import edu.christophstach.list.data.Gender;
import edu.christophstach.list.data.Program;
import edu.christophstach.list.data.Student;
import edu.christophstach.list.list.DoublyLinkedList;
import edu.christophstach.list.list.Listable;
import edu.christophstach.list.list.SinglyLinkedList;
import edu.christophstach.list.list.search.LinearSearch;
import edu.christophstach.list.list.search.Searchable;
import edu.christophstach.list.list.sort.BubbleSort;
import edu.christophstach.list.list.sort.QuickSort;
import edu.christophstach.list.list.sort.Sortable;
import edu.christophstach.list.predicate.*;
import edu.christophstach.list.util.ConsoleApplication;

import java.util.Random;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class Application {
    /**
     * Main method
     *
     * @param args commandline args
     */
    public static void main(String[] args) {
        Listable<Student> list;
        ConsoleApplication app = new ConsoleApplication();

        app.setLoopApp(true);
        app.setFooter("Vielen Dank für die Verwendung des Listenprogramms :-)");

        ConsoleApplication.clearConsole();

        System.out.println("1. SinglyLinkedList");
        System.out.println("2. DoublyLinkedList");
        int selection = ConsoleApplication.readInt("Wählen Sie aus welche Liste Sie benutzen wollen: ", value -> (value == 1 || value == 2));

        switch (selection) {
            case 1:
                list = new SinglyLinkedList<>();
                app.setHeader("\n"
                        + "SinglyLinkedList\n"
                        + "----------------\n"
                );
                break;
            case 2:
            default:
                list = new DoublyLinkedList<>();
                app.setHeader("\n"
                        + "DoublyLinkedList\n"
                        + "----------------\n"
                );
                break;
        }

        app.addMenuItem("Insert Test data", () -> {
            Random rnd = new Random();

            list.insertLast(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Christoph", "Stach", Program.APPLIED_COMPUTING, Gender.MALE));
            list.insertLast(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Laura", "Hartgers", Program.APPLIED_COMPUTING, Gender.FEMALE));
            list.insertLast(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Miles", "Lorenz", Program.APPLIED_COMPUTING, Gender.MALE));
            list.insertLast(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Steffen", "Exler", Program.APPLIED_COMPUTING, Gender.MALE));
            list.insertLast(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Marvin", "Pikarek", Program.APPLIED_COMPUTING, Gender.MALE));

            list.printAll();
        });

        app.addMenuItem("Insert First", () -> {
            list.insertFirst(Application.readStudent());
            System.out.println("\nStudent wurde eingefügt");
        });

        app.addMenuItem("Insert Last", () -> {
            list.insertLast(Application.readStudent());
            System.out.println("\nStudent wurde eingefügt");
        });

        app.addMenuItem("Insert", () -> {
            int index = 0;

            Student student = Application.readStudent();

            if (!list.empty()) {
                index = ConsoleApplication.readInt(
                        "Bitte geben Sie einen Wert für den Index von 0 - " + list.size() + " ein: ",
                        (value) -> (value >= 0 && value <= list.size())
                );
            }


            list.insert(index, student);

            System.out.println("\nStudent wurde eingefügt");
        });

        app.addMenuItem("Remove", () -> {
            int index;

            if (!list.empty()) {
                if (list.size() > 1) {
                    index = ConsoleApplication.readInt(
                            "Bitte geben Sie einen Wert für den Index von 0 - " + (list.size() - 1) + " ein: ",
                            (value) -> (value >= 0 && value < list.size())
                    );
                } else {
                    index = 0;
                }

                list.remove(index);
                System.out.println("Student wurde aus Liste enfernt");
            } else {
                System.out.println("Die Liste ist leer");
            }
        });

        app.addMenuItem("Get", () -> {
            int index;

            if (!list.empty()) {
                if (list.size() > 1) {
                    index = ConsoleApplication.readInt(
                            "Bitte geben Sie einen Wert für den Index von 0 - " + (list.size() - 1) + " ein: ",
                            (value) -> (value >= 0 && value < list.size())
                    );
                } else {
                    index = 0;
                }

                System.out.println(list.get(index));
            } else {
                System.out.println("Die Liste ist leer");
            }
        });

        app.addMenuItem("GetSize", () -> {
            System.out.println("Size: " + list.size());
        });

        app.addMenuItem("IsEmpty", () -> {
            System.out.println("IsEmpty: " + list.empty());
        });

        app.addMenuItem("ClearAll", () -> {
            list.clearAll();
            System.out.println("Liste wurde geleert");
        });

        app.addMenuItem("PrintAll", () -> {
            list.printAll();
        });

        app.addMenuItem("Search", () -> {
            Searchable<Student> searchable = new LinearSearch<>();
            Predicable<Student> predicable;

            System.out.println("1. Vorname");
            System.out.println("2. Nachname");
            System.out.println("3. Mn");
            System.out.println("4. Geschlecht");
            System.out.println("5. Studiengang");

            switch (ConsoleApplication.readInt("\nSuche nach: ", (value) -> value >= 1 && value <= 5)) {
                case 1:
                    predicable = new FirstNameEqualsPredicate(
                            ConsoleApplication.readString("Bitte Vorname eingeben: ", (value) -> true)
                    );
                    break;
                case 2:
                    predicable = new LastNameEqualsPredicate(
                            ConsoleApplication.readString("Bitte Nachname eingeben: ", (value) -> true)
                    );
                    break;
                case 3:
                    predicable = new MnEqualsPredicate(
                            ConsoleApplication.readInt("Bitte Mn eingeben: ", (value) -> true)
                    );
                    break;
                case 4:
                    System.out.println();
                    for (int i = 0; i < Gender.values().length; i++) {
                        System.out.println(i + ": " + Gender.values()[i]);
                    }
                    System.out.println();

                    predicable = new GenderEqualsPredicate(
                            Gender.values()[ConsoleApplication.readInt(
                                    "Bitte das Geschlecht auswählen: ",
                                    (value) -> (value >= 0 && value < Gender.values().length)
                            )]
                    );
                    break;
                case 5:
                    System.out.println();
                    for (int i = 0; i < Program.values().length; i++) {
                        System.out.println(i + ": " + Program.values()[i]);
                    }
                    System.out.println();
                    predicable = new ProgramEqualsPredicate(
                            Program.values()[ConsoleApplication.readInt(
                                    "Bitte den Studiengang auswählen: ",
                                    (value) -> (value >= 0 && value < Program.values().length)
                            )]
                    );
                    break;
                default:
                    throw new RuntimeException();
            }

            System.out.println("\nFirst Student found: " + list.search(searchable, predicable));
        });

        app.addMenuItem("Sort", () -> {
            Sortable<Student> sortable;
            Comparable<Student> comparable;

            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");

            switch (ConsoleApplication.readInt("\nBitte den Suchalgorithmus auswählen: ", (value) -> value >= 0 && value <= 4)) {
                case 1:
                    sortable = new BubbleSort<>();
                    break;
                case 2:
                    sortable = new QuickSort<>();
                    break;
                default:
                    throw new RuntimeException();
            }

            System.out.println("\n1. Vorname");
            System.out.println("2. Nachname");
            System.out.println("3. Mn");
            System.out.println("4. Geschlecht");
            System.out.println("5. Studiengang");

            switch (ConsoleApplication.readInt("\nBitte Comparator auswählen: ", (value) -> value >= 0 && value <= 5)) {
                case 1:
                    comparable = new FirstNameComparator();
                    break;
                case 2:
                    comparable = new LastNameComparator();
                    break;
                case 3:
                    comparable = new MnComparator();
                    break;
                case 4:
                    comparable = new GenderComparator();
                    break;
                case 5:
                    comparable = new ProgramComparator();
                    break;
                default:
                    throw new RuntimeException();
            }

            list.sort(sortable, comparable);
            System.out.println("\nDie Liste wurde sortiert");
        });


        app.run();
    }

    /**
     * Liest Werte aus der Kommandozeile und speichert Sie in ein Student-Objekt
     *
     * @return Der Student
     */
    private static Student readStudent() {
        Student student = new Student();
        student.setMn(ConsoleApplication.readInt("Bitte die MatrikelNr eingeben: ", (value) -> true));
        student.setFirstName(ConsoleApplication.readString("Bitte den Vornamen eingeben: ", (value) -> true));
        student.setLastName(ConsoleApplication.readString("Bitte den Nachnamen eingeben: ", (value) -> true));

        System.out.println();
        for (int i = 0; i < Program.values().length; i++) {
            System.out.println(i + ": " + Program.values()[i]);
        }
        System.out.println();
        student.setProgram(
                Program.values()[ConsoleApplication.readInt(
                        "Bitte den Studiengang auswählen: ",
                        (value) -> (value >= 0 && value < Program.values().length)
                )]
        );

        System.out.println();
        for (int i = 0; i < Gender.values().length; i++) {
            System.out.println(i + ": " + Gender.values()[i]);
        }
        System.out.println();
        student.setGender(
                Gender.values()[ConsoleApplication.readInt(
                        "Bitte das Geschlecht auswählen: ",
                        (value) -> (value >= 0 && value < Gender.values().length)
                )]
        );

        return student;
    }
}
