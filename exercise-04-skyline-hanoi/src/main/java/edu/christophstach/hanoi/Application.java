/*
 * Copyright (c) 2017 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.hanoi;

import edu.christophstach.hanoi.game.TowersOfHanoi;
import edu.christophstach.util.ConsoleApplication;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 1/7/17
 */
public class Application {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        long startTime, endTime, timeUsed;
        int discCount = ConsoleApplication.readInt("Bitte Anzahl (> 0) der Scheiben  eingeben: ", (value -> value > 0));

        TowersOfHanoi hanoi = new TowersOfHanoi(discCount);

        hanoi.setVerbose(false);
        startTime = System.nanoTime();
        hanoi.solve();
        endTime = System.nanoTime();
        timeUsed = endTime - startTime;

        System.out.println(hanoi);
        System.out.printf("\n\nEs wurden  %d Verschiebungen benötigt und das hat %.3f sec gedauert", hanoi.getMovesDone(), (timeUsed / 1000.0 / 1000.0 / 1000.0));
    }
}
