package edu.christophstach.ggt;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class GreatestCommonDivisorTest {
    @Test
    public void divisionRestIt() {
        Assert.assertEquals(
            GreatestCommonDivisor.divisionRestIt(693, 286),
            11
        );
    }

    @Test
    public void divisionRestRec() {
        Assert.assertEquals(
            GreatestCommonDivisor.divisionRestRec(693, 286),
            11
        );
    }

    @Test
    public void euclidIt() {
        Assert.assertEquals(
            GreatestCommonDivisor.euclidIt(693, 286),
            11
        );
    }

    @Test
    public void euclidRec() {
        Assert.assertEquals(
            GreatestCommonDivisor.euclidRec(693, 286),
            11
        );
    }
}
