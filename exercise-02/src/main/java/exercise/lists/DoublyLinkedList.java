package exercise.lists;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public class DoublyLinkedList<T> implements Listable<T> {
    private Node head;
    private Node tail;

    private class Node {
        public T data;
        public Node next;
        public Node prev;
    }

    @Override
    public void add(T data) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void insertAt(int index, T data) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void printAll() {
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T get(int i) {
        return null;
    }
}
