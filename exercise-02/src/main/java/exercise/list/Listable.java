package exercise.list;

/**
 * Interface for lists
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public interface Listable<T> extends Sortable<T> {
    /**
     * Inserts an element into the first position of the list
     *
     * @param data The element
     */
    public void insertFirst(T data);

    /**
     * Inserts an element into the last position of the list
     *
     * @param data The element
     */
    public void insertLast(T data);

    /**
     * Inserts an element into a chosen position of the list
     *
     * @param index The index
     * @param data  The element
     * @throws IndexOutOfBoundsException Is thrown if the index is out of the list bounds
     */
    public void insert(int index, T data);

    /**
     * Removes an element from the list
     *
     * @param index The index
     * @throws IndexOutOfBoundsException Is thrown if the index is out of the list bounds
     */
    public void remove(int index);


    /**
     * Empties the list
     */
    public void clearAll();

    /**
     * Returns the size of the list
     *
     * @return The size
     */
    public int size();

    /**
     * Prints the complete list to the console
     */
    public void printAll();

    /**
     * Checks if the list is empty
     *
     * @return true = list is empty, false = list is not empty
     */
    public boolean empty();

    /**
     * Returns an element from the list
     *
     * @param index The index
     * @return The element
     * @throws IndexOutOfBoundsException Is thrown if the index is out of the list bounds
     */
    public T get(int index);


    // TODO: sort
    // TODO: search
}
