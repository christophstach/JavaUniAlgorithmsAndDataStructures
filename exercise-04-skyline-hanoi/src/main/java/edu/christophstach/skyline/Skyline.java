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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/14/16
 */
public class Skyline {
    private List<Building> list;
    private int width;

    /**
     * Constructor
     */
    public Skyline() {
        this.list = new LinkedList<>();
    }

    /**
     * Constructor
     *
     * @param buildings An array of buildings
     */
    public Skyline(Building[] buildings) {
        this.list = Arrays.asList(buildings);
    }

    /**
     * Constructor
     *
     * @param list A list of buildings
     */
    public Skyline(List<Building> list) {
        this.list = list;
    }


    /**
     * Adds a building to the list.
     *
     * @param building The building
     */
    public void addBuilding(Building building) {
        list.add(building);

        width = width >= building.getWidth() + building.getPosition() ? width : building.getWidth() + building.getPosition();
    }

    /**
     * Calculates the height of the skyline at the chosen position
     *
     * @param position The position x where to calculate the height
     * @return The height at the position x
     */
    public int getHeightAtPosition(int position) {
        int maxHeight = 0;

        for (Building building : list) {
            if (position >= building.getPosition() && maxHeight < building.getHeight()) {
                if (position <= (building.getPosition() + building.getWidth())) {
                    maxHeight = maxHeight < building.getHeight() ? building.getHeight() : maxHeight;
                }
            }
        }

        return maxHeight;
    }

    /**
     * Getter for the width of the Skyline
     *
     * @return The width
     */
    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        String s = "Skyline Breite: " + width + "\n";

        for (int i = 0; i < width; i++) {
            int height = getHeightAtPosition(i);
            for (int j = 0; j < height; j++) {
                s += "#";
            }
            s += " " + height + "\n";
        }

        return s;
    }
}
