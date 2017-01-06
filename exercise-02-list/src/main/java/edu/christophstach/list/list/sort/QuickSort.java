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
import edu.christophstach.list.list.Listable;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/21/16
 */
public class QuickSort<T> implements Sortable<T> {
    @Override
    public void sort(Listable<T> listable, Comparable<T> comparable) {
        quickSort(listable, comparable, 0, listable.size() - 1);
    }

    /**
     * Sorts the list recursively with the quickSort algorithm
     *
     * @param listable   The list
     * @param comparable The comparator
     * @param from       The index from which to sort
     * @param to         The index to which to sort
     */
    private void quickSort(Listable<T> listable, Comparable<T> comparable, int from, int to) {
        if (from < to) {
            int pivotIndex = sortFromTo(listable, comparable, from, to);

            quickSort(listable, comparable, from, pivotIndex - 1);
            quickSort(listable, comparable, pivotIndex + 1, to);
        }
    }

    /**
     * Is doing one part of the sorting, moves all elements smaller of the pivot, left to it and all elements
     * bigger than the pivot, right to it. Afterwards it returns the index of the pivot element.
     *
     * @param listable   The list
     * @param comparable The comparator
     * @param from       The index from which to sort
     * @param to         The index to which to sort
     * @return The index of the pivot element which was found
     */
    private int sortFromTo(Listable<T> listable, Comparable<T> comparable, int from, int to) {
        int i = from, j = to - 1;
        T pivot = listable.get(to);

        while (i <= j) {
            if (comparable.compare(listable.get(i), pivot) > 0) {
                swap(listable, i, j);
                j--;
            } else {
                i++;
            }
        }

        swap(listable, i, to);

        return i;
    }

    /**
     * Swaps two element in the list
     *
     * @param listable The list
     * @param a        The first element
     * @param b        The second element
     */
    private void swap(Listable<T> listable, int a, int b) {
        T memorizedObject = listable.get(a);
        listable.set(a, listable.get(b));
        listable.set(b, memorizedObject);
    }
}
