/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.towersofhanoi.util;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/27/16
 */
public class InfiniteLooper {
    private int begin;
    private int end;
    private int value;

    /**
     * Constructor
     *
     * @param begin The begin
     * @param end   The end
     * @param value The value
     */
    public InfiniteLooper(int begin, int end, int value) {
        this.begin = begin;
        this.end = end;
        this.value = value;

        if (value > end || value < begin) {
            throw new IllegalArgumentException("Value must be between begin and end");
        }
    }

    /**
     * Getter for begin
     *
     * @return The begin
     */
    public int getBegin() {
        return this.begin;
    }

    /**
     * Setter for begin
     *
     * @param begin The begin
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     * Getter for end
     *
     * @return The end
     */
    public int getEnd() {
        return this.end;
    }

    /**
     * Getter for value
     *
     * @return The value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Setter for value
     *
     * @param value The value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Setter for end
     *
     * @param end The end
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * Decrements the InfiniteLoop by one
     */
    public void increment() {
        this.value = this.value < this.end ? this.value + 1 : this.begin;
    }

    /**
     * Increments the InfiniteLoop by one
     */
    public void drecrement() {
        this.value = this.value > 0 ? this.value - 1 : this.end;
    }

    /**
     * Builds the string representation of the InfiniteLooper
     *
     * @return The string representation of the InfiniteLooper
     */
    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
