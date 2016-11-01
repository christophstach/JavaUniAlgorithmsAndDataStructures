package exercise.lists;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public interface Listable<T> {
    /**
     *
     * @param data
     */
    public void add(T data);

    /**
     *
     * @param index
     */
    public void delete(int index);

    /**
     *
     * @param index
     */
    public void insertAt(int index, T data);

    /**
     *
     */
    public void clear();

    /**
     *
     * @return
     */
    public int getSize();

    /**
     *
     */
    public void printAll();

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @param i
     * @return
     */
    public T get(int i);

    // TODO: sort
    // TODO: search
}
