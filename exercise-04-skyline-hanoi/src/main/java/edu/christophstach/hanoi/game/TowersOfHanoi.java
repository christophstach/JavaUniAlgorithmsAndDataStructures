/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.hanoi.game;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/27/16
 */
public class TowersOfHanoi implements ITowersOfHanoi {
    private int movesDone;
    private final Disc[] discs;
    private final Peg[] pegs;
    private boolean verbose = true;

    /**
     * Constructor
     *
     * @param discCount The discCount
     */
    public TowersOfHanoi(int discCount) {
        this.discs = new Disc[discCount];

        this.pegs = new Peg[]{
            new Peg("A"),
            new Peg("B"),
            new Peg("C")
        };

        for (int i = 0; i < discCount; i++) {
            this.discs[discCount - i - 1] = new Disc(discCount - i);
            this.pegs[0].push(this.discs[discCount - i - 1]);
        }
    }

    /**
     * Getter for discCount
     *
     * @return The discCount
     */
    public int getDiscCount() {
        return this.discs.length;
    }

    /**
     * Getter for pegs
     *
     * @return The pegs
     */
    public Peg[] getPegs() {
        return this.pegs;
    }

    /**
     * Getter for movesDone
     *
     * @return The movesDone
     */
    public int getMovesDone() {
        return this.movesDone;
    }

    /**
     * Setter for movesDone
     *
     * @param movesDone The movesDone
     */
    public void setMovesDone(int movesDone) {
        this.movesDone = movesDone;
    }

    /**
     * Getter for verbose
     *
     * @return The verbose
     */
    public boolean isVerbose() {
        return this.verbose;
    }

    /**
     * Setter for verbose
     *
     * @param verbose The verbose
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public void moveDisc(Peg source, Peg destination) {
        if (this.verbose) {
            System.out.println("Moving Disc with size of " + source.peek().getSize() + " from " + source.getName() + " to " + destination.getName());
        }

        destination.push(source.pop());

        if (this.verbose) {

            System.out.println(this);
            System.out.println("\n\n\n\n\n");
        }

        this.movesDone++;
    }

    @Override
    public void moveDiscs(int n, Peg source, Peg destination, Peg tmp) {
        if (n == 1) {
            this.moveDisc(source, destination);
        } else if (n > 1) {
            this.moveDiscs(n - 1, source, tmp, destination);
            this.moveDisc(source, destination);
            this.moveDiscs(n - 1, tmp, destination, source);
        }
    }

    @Override
    public void solve() {
        this.moveDiscs(this.getDiscCount(), this.pegs[0], this.pegs[2], this.pegs[1]);
    }

    /**
     * Builds the string representation of the TowersOfHanoi
     *
     * @return The string representation of the TowersOfHanoi
     */
    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < this.pegs.length; i++) {
            str += "Tower " + this.pegs[i].getName() + "\n";
            str += this.pegs[i];
        }

        return str;
    }
}
