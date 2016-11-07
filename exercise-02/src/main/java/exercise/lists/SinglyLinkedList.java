package exercise.lists;

/**
 * Einfach verketteten Liste
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public class SinglyLinkedList<T> implements Listable<T> {
    private Node head;
    private int size = 0;

    private class Node {
        public T data;
        public Node next;
    }

    @Override
    public void insertLast(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        this.size++;
    }

    @Override
    public void insertFirst(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = this.head;

        this.head = newNode;
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < this.size) {
            if (index == 0) {
                this.head = this.head.next;
            } else {
                Node temp = this.head;

                while (index > 1) {
                    temp = temp.next;
                    index--;
                }

                temp.next = temp.next.next;
            }

            this.size--;
        } else {
            throw new IllegalArgumentException("Außerhalb des des Wertebereichs");
        }
    }

    @Override
    public void insert(int index, T data) {
        if (index >= 0 && index <= this.size) {
            Node newNode = new Node();
            newNode.data = data;

            if (index == 0) {
                newNode.next = this.head;
                this.head = newNode;
            } else {
                Node temp = this.head;

                while (index > 1) {
                    temp = temp.next;
                    index--;
                }

                newNode.next = temp.next;
                temp.next = newNode;
            }

            this.size++;
        } else {
            throw new IllegalArgumentException("Außerhalb des des Wertebereichs");
        }
    }

    @Override
    public void clearAll() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
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
    public boolean isEmpty() {
        return (this.head == null);
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < this.size) {
            Node temp = this.head;

            while (index > 0) {
                temp = temp.next;
                index--;
            }

            return temp.data;
        } else {
            throw new IllegalArgumentException("Außerhalb des des Wertebereichs");
        }
    }
}
