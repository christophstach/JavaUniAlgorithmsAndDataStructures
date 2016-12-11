/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exercise;

import edu.christophstach.towersofhanoi.game.TowersOfHanoi;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class ApplicationTests {
    /**
     * Tests the game with up to 25 discs and checks if the results are accurate
     */
    @Test
    public void testGame() {
        for (int i = 0; i <= 25; i++) {
            int expectedNumberOfMoves = (int) (Math.pow(2, i) - 1);

            TowersOfHanoi game = new TowersOfHanoi(i);
            game.setVerbose(false);

            Assert.assertEquals(game.getPegs()[0].size(), i);
            Assert.assertEquals(game.getPegs()[1].size(), 0);
            Assert.assertEquals(game.getPegs()[2].size(), 0);

            game.startGame();

            Assert.assertEquals(game.getPegs()[0].size(), 0);
            Assert.assertEquals(game.getPegs()[1].size(), 0);
            Assert.assertEquals(game.getPegs()[2].size(), i);
            Assert.assertEquals(expectedNumberOfMoves, game.getMovesDone());
        }
    }
}
