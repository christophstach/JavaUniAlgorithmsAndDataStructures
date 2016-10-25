import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;


/**
 * Eine Hilfsklasse zum Anzeigen einer einfachen Konsolen-Applikation
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 22.10.16
 */
public class ConsoleApplication {
    private LinkedHashMap<String, Runnable> menuItems;
    private Scanner scanner;
    private int selection;

    /**
     * Konstruktor
     */
    public ConsoleApplication() {
        this.menuItems = new LinkedHashMap<>();
        this.scanner = new Scanner(System.in);
        this.selection = -1;
    }

    /**
     * @return Gibt die Men&uuml;punkte zur&uuml;ck
     */
    public LinkedHashMap<String, Runnable> getMenuItems() {
        return menuItems;
    }

    /**
     * @param menuItems Setzt alle Men&uuml;punkte
     */
    public void setMenuItems(LinkedHashMap<String, Runnable> menuItems) {
        this.menuItems = menuItems;
    }


    /**
     * @return Gibt den Scanner zur&uuml;ck
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner Setzt den Scanner
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return Gibt die aktuelle Men&uuml;auswahl
     */
    public int getSelection() {
        return selection;
    }

    /**
     * @param selection Setzt die aktuelle Menu&uuml;auswahl
     */
    public void setSelection(int selection) {
        this.selection = selection;
    }

    /**
     * F&uuml; einen neuen Men&uuml;punkt hinzu
     *
     * @param item     Der Text des Men&uuml;punktes
     * @param runnable Die Aktion die ausgef&uuml;hrt werden soll wenn der Men&uuml;punkt ausgew&auml;t wurde
     */
    public void addMenuItem(String item, Runnable runnable) {
        this.menuItems.put(item, runnable);
    }

    /**
     * Zeigt das Men&uuml; an und fordert zur Auswahl auf
     */
    public void showMenu() {
        int i = 1;

        for (Map.Entry<String, Runnable> item : this.menuItems.entrySet()) {
            System.out.println(i + ". " + item.getKey());
            i++;
        }

        do {
            System.out.print("\nBitte geben Sie eine ganzzahligen Wert von 1-" + this.menuItems.size() + " ein: ");
            try {
                this.selection = this.scanner.nextInt();
            } catch (InputMismatchException exception) {
                this.selection = 0;
                this.scanner.next();
            }
        } while (this.selection > this.menuItems.size() || this.selection < 1);
    }

    /**
     * Startet die Funktion des Ausgewählten Men&uuml;punktes
     */
    public void handleMenuSelection() {
        int i = 1;

        for (Map.Entry<String, Runnable> item : this.menuItems.entrySet()) {
            if (i == this.selection) {
                item.getValue().run();
                break;
            }

            i++;
        }
    }

    /**
     * Liest einen Integer Wert sicher von der Komandozeile ein und fordert bei Fehleingaben zur erneuten Eingabe auf
     *
     * @param text       Der Text wird vor der Aufforderung zur Eingabe angezeigt
     * @param expression Damit kann der Bereich der Eingabe eingegrenzt werden
     * @return
     */
    public int readInt(String text, Function<Integer, Boolean> expression) {
        int value;

        do {
            System.out.print(text);
            try {
                value = this.scanner.nextInt();
            } catch (InputMismatchException exception) {
                value = 0;
                this.scanner.next();
            }
        } while (!expression.apply(value));

        return value;
    }

    /**
     * Beendet die App
     */
    public void terminate() {
        System.out.print("" +
            "\n---------------------------------------------------------------" +
            "\nDruecken Sie eine beliebige Taste um das Programm zu beenden...");

        try {
            System.in.read();
        } catch (IOException exception) {

        }

        System.out.println("");
        scanner.close();

        try {
            System.in.read();
        } catch (IOException exception) {

        }
    }
}
