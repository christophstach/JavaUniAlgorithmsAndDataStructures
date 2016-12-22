/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.list.list.sort;

import edu.christophstach.list.comparator.Comparable;
import edu.christophstach.list.data.Student;
import edu.christophstach.list.list.Listable;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/21/16
 */
public class HeapSort<T> implements Sortable<T> {
    private int comparisons = 0;
    private int insertions = 0;

    @Override
    public void sort(Listable<T> listable, Comparable<T> comparable) {
        this.createHeapCondition(listable, comparable);


    }

    /**
     * Creates the heap condition which is necessary for sorting
     *
     * @param listable   The list
     * @param comparable the comparator
     */
    private void createHeapCondition(Listable<T> listable, Comparable<T> comparable, int index) {
        if (index < listable.size()) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = leftChildIndex + 1;

            if (leftChildIndex < listable.size() && rightChildIndex < listable.size()) {
                if (comparable.compare(listable.get(leftChildIndex), listable.get(rightChildIndex)) > 0) {
                    if (comparable.compare(listable.get(index), listable.get(leftChildIndex)) < 0) {
                        swap(listable, index, leftChildIndex);
                    }
                } else {
                    if (comparable.compare(listable.get(index), listable.get(rightChildIndex)) < 0) {
                        swap(listable, index, rightChildIndex);
                    }
                }
            } else if (leftChildIndex < listable.size()) {
                if (comparable.compare(listable.get(index), listable.get(leftChildIndex)) < 0) {
                    swap(listable, index, leftChildIndex);
                }
            }

            this.createHeapCondition(listable, comparable, leftChildIndex);
            this.createHeapCondition(listable, comparable, rightChildIndex);
        }
    }

    /**
     * @param listable
     * @param comparable
     */
    private void createHeapCondition(Listable<T> listable, Comparable<T> comparable) {
        for (int i = ((listable.size() / 2) - 1); i >= 0; i--) {
            this.createHeapCondition(listable, comparable, i);
        }
    }

    /**
     * Swaps two element in the list
     *
     * @param listable The list
     * @param a        The first element
     * @param b        The second element
     */
    private void swap(Listable<T> listable, int a, int b) {
        insertions++;

        System.out.println(a + "(" + ((Student) listable.get(a)).getMn() + ") <-> " + b + "(" + ((Student) listable.get(b)).getMn() + ")");
        T memorizedObject = listable.get(a);
        listable.set(a, listable.get(b));
        listable.set(b, memorizedObject);
    }

    @Override
    public int countInsertions() {
        return insertions;
    }

    @Override
    public int countComparisons() {
        return comparisons;
    }
}
