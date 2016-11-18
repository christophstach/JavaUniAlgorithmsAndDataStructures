/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exercise.stack;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/15/16
 */
public class Stack<T> implements Stackable<T> {
    private Node head;
    private int size = 0;

    private class Node {
        public T data;
        public Node next;
    }

    @Override
    public void push(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = this.head;

        this.size++;
        this.head = newNode;
    }

    @Override
    public T pop() {
        if (this.head != null) {
            T data = this.head.data;
            this.head = this.head.next;

            this.size--;
            return data;
        } else {
            return null;
        }
    }

    @Override
    public T peak() {
        if (this.head != null) {
            return this.head.data;
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean empty() {
        return this.head == null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void printAll() {
        System.out.println(this.getClass().getSimpleName());

        Node temp = this.head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
