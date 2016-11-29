/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.university.sort;

import edu.christophstach.university.sort.data.FirstNameComparator;
import edu.christophstach.university.sort.data.MnComparator;
import edu.christophstach.university.sort.data.Program;
import edu.christophstach.university.sort.data.Student;
import edu.christophstach.university.sort.sort.SelectionSort;
import edu.christophstach.university.sort.sort.Sortable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/29/16
 */
public class Application {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        Student s1 = new Student(5, "Christoph", "Stach", Program.APPLIED_COMPUTING, 1);
        Student s2 = new Student(2, "Adrian", "Saiz Ferri", Program.APPLIED_COMPUTING, 1);
        Student s3 = new Student(8, "Steffen", "Exler", Program.APPLIED_COMPUTING, 1);
        Student s4 = new Student(1, "Laura", "Hartgers", Program.APPLIED_COMPUTING, 1);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);
        System.out.println("Unsortiert:");
        Application.printAllStudents(list);


        Sortable<Student> doSort = new SelectionSort<>();

        doSort.sort(list, new MnComparator());
        System.out.println("\nSortiert nach Mn:");
        Application.printAllStudents(list);

        doSort.sort(list, new FirstNameComparator());
        System.out.println("\nSortiert nach FirstName:");
        Application.printAllStudents(list);
    }

    /**
     * Prints all Students in the list
     *
     * @param list The list
     */
    public static void printAllStudents(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
