/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.towersofhanoi.game;

import edu.christophstach.towersofhanoi.util.InfiniteLooper;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/27/16
 */
public class TowersOfHanoi {
    private int movesDone;
    private final int diskCount;
    private final Rod[] rods;

    /**
     * Constructor
     *
     * @param diskCount The diskCount
     */
    public TowersOfHanoi(int diskCount) {
        this.diskCount = diskCount;

        this.rods = new Rod[]{
            new Rod(),
            new Rod(),
            new Rod()
        };
    }

    /**
     * Getter for diskCount
     *
     * @return The diskCount
     */
    public int getDiskCount() {
        return this.diskCount;
    }

    /**
     * Getter for rods
     *
     * @return The rods
     */
    public Rod[] getRods() {
        return this.rods;
    }

    /**
     * Starts a new Game
     */
    public void initializeGame() {
        for (int i = 0; i < this.diskCount; i++) {
            this.rods[0].push(new Disk(this.diskCount - i));
        }
    }

    /**
     * Makes the next turn and puts a disk on another rod
     *
     * @return Returns false if the game is finished
     */
    public boolean nextTurn() {
        if (this.movesDone % 2 == 0) {
            this.moveDiskLeft(this.getNextSourceRodIndex());
        } else {
            this.moveDiskRight(this.getNextSourceRodIndex());
        }

        this.movesDone++;

        return !this.hasGameFinished();
    }

    /**
     * TODO:
     *
     * @return
     */
    public int getNextSourceRodIndex() {
        InfiniteLooper looper = new InfiniteLooper(0, this.rods.length - 1, 0);

        for (Rod rod : this.rods) {

        }
        return 0;
    }

    /**
     * Checks if the game has finished
     *
     * @return True if the game has finished
     */
    public boolean hasGameFinished() {
        return this.rods[this.rods.length - 1].size() == this.diskCount;
    }

    /**
     * Moves a disk from the rod to the next free rod left of it
     *
     * @param sourceRodIndex The index of the rod
     */
    private void moveDiskLeft(int sourceRodIndex) {
        boolean hasMoved = false;
        InfiniteLooper destinationRodIndex = new InfiniteLooper(0, this.rods.length - 1, sourceRodIndex);

        while (!hasMoved) {
            destinationRodIndex.drecrement();

            if (this.rods[destinationRodIndex.getValue()].canPutDisk(this.rods[sourceRodIndex].peek())) {
                this.rods[destinationRodIndex.getValue()].push(this.rods[sourceRodIndex].pop());
                hasMoved = true;
            }
        }
    }

    /**
     * Moves a disk from the rod to the next free rod rod of it
     *
     * @param sourceRodIndex The index of the rod
     */
    private void moveDiskRight(int sourceRodIndex) {
        boolean hasMoved = false;
        InfiniteLooper destinationRodIndex = new InfiniteLooper(0, this.rods.length - 1, sourceRodIndex);

        while (!hasMoved) {
            destinationRodIndex.increment();

            if (this.rods[destinationRodIndex.getValue()].canPutDisk(this.rods[sourceRodIndex].peek())) {
                this.rods[destinationRodIndex.getValue()].push(this.rods[sourceRodIndex].pop());
                hasMoved = true;
            }
        }
    }

    /**
     * Builds the string representation of the TowersOfHanoi
     *
     * @return The string representation of the TowersOfHanoi
     */
    @Override
    public String toString() {
        String str = "";


        for (int i = 0; i < this.rods.length; i++) {
            str += "Tower " + (i + 1) + "\n";
            str += this.rods[i];
        }

        return str;
    }
}
