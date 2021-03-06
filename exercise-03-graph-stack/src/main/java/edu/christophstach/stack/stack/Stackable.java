/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.stack.stack;

/**
 * Interface for stacks
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/15/16
 */
public interface Stackable<T> {
    /**
     * Puts an element on top of the stack
     *
     * @param data The element
     */
    public void push(T data);

    /**
     * Returns the top element of the list with removing it
     *
     * @return The top element
     */
    public T pop();

    /**
     * Returns the top element of the stack without removing it
     *
     * @return The top element
     */
    public T peek();

    /**
     * Returns the size of the list
     *
     * @return The size
     */
    public int size();

    /**
     * Checks if the list is empty
     *
     * @return true = list is empty, false = list is not empty
     */
    public boolean empty();


    /**
     * Empties the stack
     */
    public void clearAll();

    /**
     * Prints the complete stack to the console
     */
    public void printAll();
}
