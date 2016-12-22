/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.list;

import edu.christophstach.list.comparator.Comparable;
import edu.christophstach.list.comparator.MnComparator;
import edu.christophstach.list.data.Gender;
import edu.christophstach.list.data.Program;
import edu.christophstach.list.data.Student;
import edu.christophstach.list.list.DoublyLinkedList;
import edu.christophstach.list.list.Listable;
import edu.christophstach.list.list.search.LinearSearch;
import edu.christophstach.list.list.search.Searchable;
import edu.christophstach.list.list.sort.BubbleSort;
import edu.christophstach.list.list.sort.HeapSort;
import edu.christophstach.list.list.sort.QuickSort;
import edu.christophstach.list.list.sort.Sortable;
import edu.christophstach.list.predicate.FirstNameEqualsPredicate;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/14/16
 */
public class ManualTest {
    /**
     * Just a class for doing manual tests.
     * I left it becuase of convenience.
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        Listable<Student> list = new DoublyLinkedList<>();

        Sortable<Student> sortable = new HeapSort<>();
        Searchable<Student> searchable = new LinearSearch<>();

        Comparable comparable = new MnComparator();

        /*list.insertFirst(new Student(5559123, "Christoph", "Stach", Program.APPLIED_COMPUTING, Gender.MALE));
        list.insertFirst(new Student(5559124, "Laura", "Hartgers", Program.APPLIED_COMPUTING, Gender.FEMALE));
        list.insertFirst(new Student(5559125, "Miles", "Lorenz", Program.APPLIED_COMPUTING, Gender.MALE));
        list.insertFirst(new Student(5559126, "Steffen", "Exler", Program.APPLIED_COMPUTING, Gender.MALE));
        list.insertFirst(new Student(5559127, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));

        list.insertFirst(new Student(5559128, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));
        list.insertFirst(new Student(5559129, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));
        list.insertFirst(new Student(5559130, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));*/

        list.insertLast(new Student(2, "Christoph", "Stach", Program.APPLIED_COMPUTING, Gender.MALE));
        list.insertLast(new Student(1, "Laura", "Hartgers", Program.APPLIED_COMPUTING, Gender.FEMALE));
        list.insertLast(new Student(5, "Miles", "Lorenz", Program.APPLIED_COMPUTING, Gender.MALE));
        list.insertLast(new Student(3, "Steffen", "Exler", Program.APPLIED_COMPUTING, Gender.MALE));
        list.insertLast(new Student(4, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));

        list.insertLast(new Student(8, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));
        list.insertLast(new Student(7, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));
        list.insertLast(new Student(6, "Laila", "Westphal", Program.APPLIED_COMPUTING, Gender.FEMALE));



        System.out.println("\n\nAfter sort\n\n");
        list.printAll();

        list.sort(sortable, comparable);

        System.out.println("\n\nAfter sort: " + sortable.countComparisons() + " Comparisons, " + sortable.countInsertions() + " Insertions\n\n");
        list.printAll();

        System.out.println("\n\nSearch" + list.search(new LinearSearch<Student>(), new FirstNameEqualsPredicate("Christoph")));
    }
}
