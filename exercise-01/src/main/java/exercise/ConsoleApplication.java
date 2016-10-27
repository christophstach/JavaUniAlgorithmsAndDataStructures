package exercise;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;


/**
 * Eine Hilfsklasse zum Anzeigen einer einfachen Konsolenanwendung
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 22.10.16
 */
public class ConsoleApplication {
    private LinkedHashMap<String, Runnable> menuItems;
    private Scanner scanner;
    private int selection;
    private String header;
    private String footer;
    private boolean loopApp;
    private boolean terminateApp;

    /**
     * Konstruktor
     */
    public ConsoleApplication() {
        this.menuItems = new LinkedHashMap<>();
        this.scanner = new Scanner(System.in);
        this.selection = -1;
        this.header = "";
        this.footer = "";
        this.loopApp = false;
        this.terminateApp = false;
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
     * @return Gibt den aktuellen Header zur&uuml;ck
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header Setzt den aktuellen Header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return Gibt den aktuellen Footer zur&uuml;ck
     */
    public String getFooter() {
        return footer;
    }

    /**
     * @param footer Setzt den aktuellen Footer
     */
    public void setFooter(String footer) {
        this.footer = footer;
    }

    /**
     * @return Gibt an ob die Anwendung sich nach der Ausf&uuml;hrung wiederholen soll
     */
    public boolean isLoopApp() {
        return loopApp;
    }

    /**
     * @param loopApp Gibt an ob die Anwendung sich nach der Ausf&uuml;hrung wiederholen soll
     */
    public void setLoopApp(boolean loopApp) {
        this.loopApp = loopApp;
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

        System.out.println();

        do {
            System.out.print("Bitte geben Sie eine ganzzahligen Wert von 1-" + this.menuItems.size() + " ein: ");
            try {
                this.selection = this.scanner.nextInt();
            } catch (InputMismatchException exception) {
                this.selection = 0;
                this.scanner.next();
            }
        } while (this.selection > this.menuItems.size() || this.selection < 1);

        System.out.println();
    }

    /**
     * Startet die Funktion des Ausgewählten Men&uuml;punktes
     */
    public void handleMenuSelection() {
        int i = 1;

        for (Map.Entry<String, Runnable> item : this.menuItems.entrySet()) {
            if (i == this.selection) {
                item.getValue().run();

                if (this.loopApp && !this.terminateApp) {
                    System.out.println();
                    this.showMenu();
                    this.handleMenuSelection();
                }
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
     * @return Sicher eingelesener int wert
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
                continue;
            }
        } while (!expression.apply(value));

        return value;
    }

    /**
     * Beendet die App
     */
    public void terminate() {
        this.terminate(false);
    }

    /**
     * Beendet die App
     *
     * @param pauseOnTerminate gibt an ob die App eine letzte finale Eingabe erwartet und damit vorm Beenden pausiert wird
     */
    public void terminate(boolean pauseOnTerminate) {
        if (pauseOnTerminate) {
            System.out.print("" +
                "\n---------------------------------------------------------------" +
                "\nDruecken Sie eine beliebige Taste um das Programm zu beenden...");

            try {
                System.in.read();
            } catch (IOException exception) {

            }
        }

        System.out.println();
        scanner.close();

        try {
            System.in.read();
        } catch (IOException exception) {

        }
    }

    /**
     * Startet die App
     */
    public void run() {
        if (!this.header.isEmpty()) {
            System.out.println(this.header);
        }

        if (this.loopApp) {
            this.addMenuItem("Programm beenden", () -> this.terminateApp = true);
        }
        this.showMenu();
        this.handleMenuSelection();

        if (!this.footer.isEmpty()) {
            System.out.println(this.footer);
        }
    }
}
