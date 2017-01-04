/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.stack;

import edu.christophstach.stack.util.ConsoleApplication;
import edu.christophstach.stack.data.Gender;
import edu.christophstach.stack.data.Program;
import edu.christophstach.stack.data.Student;
import edu.christophstach.stack.stack.Stack;
import edu.christophstach.stack.stack.Stackable;

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
        Stackable<Student> stack = new Stack<>();
        ConsoleApplication app = new ConsoleApplication();

        app.setFooter("Vielen Dank für die Verwendung des Stackprogramms :-)");
        app.setLoopApp(true);

        app.addMenuItem("Push Test data", () -> {
            Random rnd = new Random();

            stack.push(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Christoph", "Stach", Program.APPLIED_COMPUTING, Gender.MALE));
            stack.push(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Laura", "Hartgers", Program.APPLIED_COMPUTING, Gender.FEMALE));
            stack.push(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Miles", "Lorenz", Program.APPLIED_COMPUTING, Gender.MALE));
            stack.push(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Steffen", "Exler", Program.APPLIED_COMPUTING, Gender.MALE));
            stack.push(new Student(Integer.parseInt("555" + (rnd.nextInt(100) + 100)), "Marvin", "Pikarek", Program.APPLIED_COMPUTING, Gender.MALE));

            stack.printAll();
        });

        app.addMenuItem("Push", () -> {
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

            stack.push(student);
        });

        app.addMenuItem("Pop", () -> {
            System.out.println("Return von stack.pop(): " + stack.pop());
        });

        app.addMenuItem("Peak", () -> {
            System.out.println("Return von stack.peak(): " + stack.peak());
        });

        app.addMenuItem("Size", () -> {
            System.out.println("Return von stack.size(): " + stack.size());
        });

        app.addMenuItem("Empty", () -> {
            System.out.println("Return von stack.empty(): " + stack.empty());
        });

        app.addMenuItem("ClearAll", () -> {
            stack.clearAll();
            System.out.println("Stack wurde geleert");
        });

        app.addMenuItem("PrintAll", () -> {
            stack.printAll();
        });

        app.run();
    }
}
