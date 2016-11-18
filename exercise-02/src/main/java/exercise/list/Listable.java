package exercise.list;

/**
 * Interface welches von Listen implementiert werden muss
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public interface Listable<T> {
    /**
     * Fuegt ein Element an den Anfang der Liste an
     *
     * @param data Das Element
     */
    public void insertFirst(T data);

    /**
     * Fuegt ein Element an das Ende der Liste an
     *
     * @param data Das Element
     */
    public void insertLast(T data);

    /**
     * @param index Der Index
     * @param data  Das Element
     */
    public void insert(int index, T data);

    /**
     * Loescht ein Element
     *
     * @param index Der Index
     */
    public void remove(int index);


    /**
     * Leert die Liste
     */
    public void clearAll();

    /**
     * Gibt die Laenge der Liste zurueck
     *
     * @return Die Laenge
     */
    public int getSize();

    /**
     * Gibt die komplette Liste auf der Konsole aus
     */
    public void printAll();

    /**
     * Ueberprueft of die Liste leer ist
     *
     * @return TRUE = Liste leer, FALSE = Liste nicht leer
     */
    public boolean isEmpty();

    /**
     * Gibt ein Element am angegebenen Index zurueck
     *
     * @param index Der Index
     * @return Das Element
     */
    public T get(int index);

    // TODO: sort
    // TODO: search
}
