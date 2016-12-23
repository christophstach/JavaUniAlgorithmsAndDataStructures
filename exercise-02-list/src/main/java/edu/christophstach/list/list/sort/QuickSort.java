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
import edu.christophstach.list.list.DoublyLinkedList;
import edu.christophstach.list.list.Listable;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/21/16
 */
public class QuickSort<T> implements Sortable<T> {
    @Override
    public void sort(Listable<T> listable, Comparable<T> comparable) {
        if (listable.size() > 1) {
            int pivotIndex = listable.size() / 2;

            T pivot = listable.get(pivotIndex);
            Listable<T> leftOfPivot = new DoublyLinkedList<>();
            Listable<T> rightOfPivot = new DoublyLinkedList<>();

            for (int i = 0; i < listable.size(); i++) {
                if (i != pivotIndex) {
                    T current = listable.get(i);

                    if (comparable.compare(current, pivot) < 0) {
                        leftOfPivot.insertLast(current);
                    } else {
                        rightOfPivot.insertLast(current);
                    }
                }
            }

            this.sort(leftOfPivot, comparable);
            this.sort(rightOfPivot, comparable);

            listable.clearAll();

            for (int i = 0; i < leftOfPivot.size(); i++) {
                listable.insertLast(leftOfPivot.get(i));
            }

            listable.insertLast(pivot);

            for (int i = 0; i < rightOfPivot.size(); i++) {
                listable.insertLast(rightOfPivot.get(i));
            }
        }
    }
}
