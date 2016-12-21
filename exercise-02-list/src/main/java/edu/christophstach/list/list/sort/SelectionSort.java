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
 * @since 11/29/16
 */
public class SelectionSort<T> implements Sortable<T> {
    private int comparisons = 0;
    private int insertions = 0;

    @Override
    public void sort(Listable<T> listable, Comparable<T> comparable) {
        int min;

        for (int i = 0; i < listable.size(); i++) {
            min = i;

            for (int j = i + 1; j < listable.size(); j++) {
                comparisons++;

                if (comparable.compare(listable.get(j), listable.get(min)) < 0) {
                    min = j;
                }
            }

            this.swap(listable, i, min);
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
