import java.util.LinkedList;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 22.10.16
 */
public class Menu {
    private LinkedList<String> menuItems;

    public void addItem(String item) {
        this.menuItems.add(item);
    }
}
