import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class ConsoleApplicationTest {
    private ConsoleApplication app;

    public void setUp() {
        this.app = new ConsoleApplication();

    }

     @Test
    public void readInt() {
        this.app.getScanner();
        Assert.assertEquals(5, this.app.readInt("Test: ", (value) -> value > 0));
    }
}
