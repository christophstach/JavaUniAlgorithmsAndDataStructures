/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.list.list;

import edu.christophstach.list.comparator.Comparable;
import edu.christophstach.list.list.search.Searchable;
import edu.christophstach.list.list.sort.Sortable;
import edu.christophstach.list.predicate.Predicable;

/**
 * Doubly linked list
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public class DoublyLinkedList<T> implements Listable<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        public T data;
        public Node next;
        public Node prev;
    }

    @Override
    public void insertFirst(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = this.head;

        this.head = newNode;

        if (this.size == 0) {
            this.tail = newNode;
        } else {
            newNode.next.prev = newNode;
        }

        this.size++;
    }

    @Override
    public void insertLast(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = this.tail;

        this.tail = newNode;

        if (this.size == 0) {
            this.head = newNode;
        } else {
            newNode.prev.next = newNode;
        }

        this.size++;
    }

    @Override
    public void insert(int index, T data) {
        if (index >= 0 && index <= this.size) {
            if (index == 0) {
                this.insertFirst(data);
            } else if (index == this.size) {
                this.insertLast(data);
            } else if (index < (this.size / 2)) {
                Node newNode = new Node();
                newNode.data = data;

                // Walks list from the head towards the tail
                Node temp = this.head;

                while (index > 0) {
                    temp = temp.next;
                    index--;
                }

                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;

                this.size++;
            } else {
                Node newNode = new Node();
                newNode.data = data;

                Node temp = this.tail;
                index = this.size - index - 1;

                while (index > 0) {
                    temp = temp.prev;
                    index--;
                }

                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;

                this.size++;
            }
        } else {
            throw new IndexOutOfBoundsException("The index:" + index + " is out of bounds");
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < this.size) {

            if (index == 0) {
                this.head = this.head.next;
                this.head.prev = null;
            } else if (index == (this.size - 1)) {
                this.tail = this.tail.prev;
                this.tail.next = null;
            } else if (index < (this.size / 2)) {
                // Walks list from the head towards the tail
                Node temp = this.head;

                while (index > 0) {
                    temp = temp.next;
                    index--;
                }

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            } else {
                // Walks list from the tail towards the head
                Node temp = this.tail;
                index = this.size - index - 1;

                while (index > 0) {
                    temp = temp.prev;
                    index--;
                }

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }

            this.size--;
        } else {
            throw new IndexOutOfBoundsException("The index:" + index + " is out of bounds");
        }
    }

    @Override
    public void clearAll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
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

    @Override
    public boolean empty() {
        return (this.head == null && this.tail == null);
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < this.size) {
            if (index == 0) {
                return this.head.data;
            } else if (index == (this.size - 1)) {
                return this.tail.data;
            } else if (index < (this.size / 2)) {
                // Walks list from the head towards the tail
                Node temp = this.head;

                while (index > 0) {
                    temp = temp.next;
                    index--;
                }

                return temp.data;
            } else {
                // Walks list from the tail towards the head
                Node temp = this.tail;
                index = this.size - index - 1;

                while (index > 0) {
                    temp = temp.prev;
                    index--;
                }

                return temp.data;
            }
        } else {
            throw new IndexOutOfBoundsException("The index:" + index + " is out of bounds");
        }
    }

    @Override
    public void set(int index, T data) {
        if (index >= 0 && index < this.size) {
            if (index == 0) {
                this.head.data = data;
            } else if (index == (this.size - 1)) {
                this.tail.data = data;
            } else if (index < (this.size / 2)) {
                // Walks list from the head towards the tail
                Node temp = this.head;

                while (index > 0) {
                    temp = temp.next;
                    index--;
                }

                temp.data = data;
            } else {
                // Walks list from the tail towards the head
                Node temp = this.tail;
                index = this.size - index - 1;

                while (index > 0) {
                    temp = temp.prev;
                    index--;
                }

                temp.data = data;
            }
        } else {
            throw new IndexOutOfBoundsException("The index:" + index + " is out of bounds");
        }
    }

    @Override
    public T search(Searchable<T> searchable, Predicable<T> predicable) {
        return searchable.search(this, predicable);
    }

    @Override
    public void sort(Sortable<T> sortable, Comparable<T> comparable) {
        sortable.sort(this, comparable);
    }
}

