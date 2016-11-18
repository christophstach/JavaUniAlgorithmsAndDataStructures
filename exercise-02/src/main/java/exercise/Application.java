package exercise;

import exercise.data.Gender;
import exercise.data.Program;
import exercise.data.Student;
import exercise.list.DoublyLinkedList;
import exercise.list.Listable;
import exercise.list.SinglyLinkedList;
import exercise.util.ConsoleApplication;

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
        Listable<Student> list;
        ConsoleApplication app = new ConsoleApplication();

        app.setLoopApp(true);

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

        app.addMenuItem("Insert First", () -> {
            list.insertFirst(Application.readStudent());
        });

        app.addMenuItem("Insert Last", () -> {
            list.insertLast(Application.readStudent());
        });

        app.addMenuItem("Insert", () -> {
            int index = 0;
            Student student = Application.readStudent();

            if (!list.isEmpty()) {
                index = ConsoleApplication.readInt(
                    "Bitte geben Sie einen Wert für den Index von 0 - " + list.getSize() + " ein: ",
                    (value) -> (value >= 0 && value <= list.getSize())
                );
            }


            list.insert(index, student);
        });

        app.addMenuItem("Remove", () -> {
            int index = 0;

            if (!list.isEmpty()) {
                if (list.getSize() > 1) {
                    index = ConsoleApplication.readInt(
                        "Bitte geben Sie einen Wert für den Index von 0 - " + list.getSize() + " ein: ",
                        (value) -> (value >= 0 && value < list.getSize())
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
            int index = 0;

            if (!list.isEmpty()) {
                if (list.getSize() > 1) {
                    index = ConsoleApplication.readInt(
                        "Bitte geben Sie einen Wert für den Index von 0 - " + list.getSize() + " ein: ",
                        (value) -> (value >= 0 && value < list.getSize())
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
            System.out.println("Size: " + list.getSize());
        });

        app.addMenuItem("IsEmpty", () -> {
            System.out.println("IsEmpty: " + list.isEmpty());
        });

        app.addMenuItem("ClearAll", () -> {
            list.clearAll();
            System.out.println("Liste wurde geleert");
        });

        app.addMenuItem("PrintAll", () -> {
            list.printAll();
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

        System.out.println("");
        for (int i = 0; i < Program.values().length; i++) {
            System.out.println(i + ": " + Program.values()[i]);
        }
        System.out.println("");
        student.setProgram(
            Program.values()[ConsoleApplication.readInt(
                "Bitte den Studiengang auswählen: ",
                (value) -> (value >= 0 && value < Program.values().length)
            )]
        );

        System.out.println("");
        for (int i = 0; i < Gender.values().length; i++) {
            System.out.println(i + ": " + Gender.values()[i]);
        }
        System.out.println("");
        student.setGender(
            Gender.values()[ConsoleApplication.readInt(
                "Bitte das Geschlecht auswählen: ",
                (value) -> (value >= 0 && value < Gender.values().length)
            )]
        );

        return student;
    }
}
