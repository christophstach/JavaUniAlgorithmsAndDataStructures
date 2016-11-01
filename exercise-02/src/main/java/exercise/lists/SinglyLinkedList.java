package exercise.lists;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public class SinglyLinkedList<T> implements Listable<T> {
    private Node head;
    private int size;

    private class Node {
        public T data;
        public Node next;
    }

    @Override
    public void add(T data) {
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
    public void delete(int index) {
        this.size--;
    }

    @Override
    public void insertAt(int index, T data) {
        this.size++;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void printAll() {
        System.out.println(this.getClass().getSimpleName());

        Node temp = this.head;

        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return (this.head == null);
    }

    @Override
    public T get(int i) {
        if(i >= 0 && i < this.size) {
            Node temp = this.head;

            while(i > 0) {
                temp = temp.next;
                i--;
            }

            return temp.data;
        } else {
            throw new IllegalArgumentException("Außerhalb des des Wertebereichs");
        }
    }
}
