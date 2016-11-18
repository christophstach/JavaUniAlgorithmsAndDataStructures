package exercise.list;

/**
 * Interface welches von Listen implementiert werden muss
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public interface Listable<T> {
    /**
     * F&uuml;gt ein Element an den Anfang der Liste an
     *
     * @param data Das Element
     */
    public void insertFirst(T data);

    /**
     * F&uuml;gt ein Element an das Ende der Liste an
     *
     * @param data Das Element
     */
    public void insertLast(T data);

    /**
     * @param index Der Index
     * @param data  Das Element
     * @throws IllegalArgumentException Wenn der index au&szlig;erhalb des Wertebereichs liegt
     */
    public void insert(int index, T data);

    /**
     * L&ouml;scht ein Element
     *
     * @param index Der Index
     * @throws IllegalArgumentException Wenn der index au&szlig;erhalb des Wertebereichs liegt
     */
    public void remove(int index);


    /**
     * Leert die Liste
     */
    public void clearAll();

    /**
     * Gibt die Laenge der Liste zur&uuml;ck
     *
     * @return Die Laenge
     */
    public int getSize();

    /**
     * Gibt die komplette Liste auf der Konsole aus
     */
    public void printAll();

    /**
     * &Uuml;berpr&uuml;ft of die Liste leer ist
     *
     * @return TRUE = Liste leer, FALSE = Liste nicht leer
     */
    public boolean isEmpty();

    /**
     * Gibt ein Element am angegebenen Index zur&uuml;ck
     *
     * @param index Der Index
     * @return Das Element
     */
    public T get(int index);

    // TODO: sort
    // TODO: search
}
