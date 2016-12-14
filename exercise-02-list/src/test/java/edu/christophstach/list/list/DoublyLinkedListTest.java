package edu.christophstach.list.list;

import org.junit.Before;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 11/1/16.
 */
public class DoublyLinkedListTest extends ListableTest {
    @Before
    public void setUp() {
        super.setUp();
        this.list = new DoublyLinkedList<>();
    }
}
