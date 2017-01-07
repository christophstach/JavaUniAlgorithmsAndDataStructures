/*
 * Copyright (c) 2017 Christoph Stach <christoph.stach@gmail.com>
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
 * @since 1/7/17
 */
public interface ITowersOfHanoi {
    /**
     * Solves the puzzle
     */
    void solve();

    /**
     * Puts a disc from a source peg to the destination peg
     *
     * @param source      The source peg
     * @param destination The destination peg
     */
    void moveDisc(Peg source, Peg destination);

    /**
     * Moves n discs from the source peg to the destination peg using the tmp peg.
     * If n is greater than one the, first n-1 disc will be moved recursively to the tmp peg before the
     * biggest disc is moved to the destination peg. In the end all discs from the tmp peg will be moved again recursively
     * to the destination peg.
     *
     * @param n           Number of discs
     * @param source      The source peg
     * @param destination The destination peg
     * @param tmp         The temporary peg
     */
    public void moveDiscs(int n, Peg source, Peg destination, Peg tmp);
}
