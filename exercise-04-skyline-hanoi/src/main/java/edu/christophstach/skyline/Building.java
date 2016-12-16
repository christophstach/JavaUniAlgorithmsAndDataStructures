/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.skyline;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/14/16
 */
public class Building {
    private int width;
    private int height;
    private int position;

    public Building() {
    }

    public Building(int width, int height, int position) {
        this.width = width;
        this.height = height;
        this.position = position;
    }

    /**
     * Getter for width
     *
     * @return The width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Setter for width
     *
     * @param width The width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Getter for height
     *
     * @return The height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Setter for height
     *
     * @param height The height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Getter for position
     *
     * @return The position
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Setter for position
     *
     * @param position The position
     */
    public void setPosition(int position) {
        this.position = position;
    }
}
