/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package stack;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/15/16
 */
public interface Stackable<T> {
    /**
     * Legt ein Element oben auf den Stack drauf
     *
     * @param data Das Element
     */
    public void push(T data);

    /**
     * Nimmst das oberste Element vom Stack runter und gibt es zurück
     *
     * @return Das oberste Element
     */
    public T pop();

    /**
     * Gibt das oberste Elemet des Stacks zurück ohne es zu entfernen
     *
     * @return Das oberste Element
     */
    public T peak();

    /**
     * Gibt die Größe des Stacks zurück
     *
     * @return Die Größe Stacks
     */
    public int size();

    /**
     * Gibt zurück ob der Stack leer ist
     *
     * @return True = Leer; False = Nicht Leer
     */
    public boolean empty();


    /**
     * Leert den Stack
     */
    public void clear();

    /**
     * Gibt den kompletten Stack auf der Konsole aus
     */
    public void printAll();
}
