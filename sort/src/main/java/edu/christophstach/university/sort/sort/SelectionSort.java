/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.university.sort.sort;

import java.util.List;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/29/16
 */
public class SelectionSort<T> implements Sortable<T> {
    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        int min = 0;

        for (int i = 0; i < list.size(); i++) {
            min = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(min)) < 0) {
                    min = j;
                }
            }
            this.swap(list, i, min);
        }
    }

    private void swap(List<T> list, int a, int b) {
        T memorizedObject = list.get(a);
        list.set(a, list.get(b));
        list.set(b, memorizedObject);
    }
}
