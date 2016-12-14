/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.stack.util;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;


/**
 * A utility class for simple console applications
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 22.10.16
 */
public class ConsoleApplication {
    private LinkedHashMap<String, Runnable> menuItems;
    private static Scanner scanner = new Scanner(System.in);
    private int selection;
    private String header;
    private String footer;
    private boolean loopApp;
    private boolean terminateApp;

    /**
     * Constructor
     */
    public ConsoleApplication() {
        this.menuItems = new LinkedHashMap<>();
        this.selection = -1;
        this.header = "";
        this.footer = "";
        this.loopApp = false;
        this.terminateApp = false;
    }

    /**
     * Getter for menuItems
     *
     * @return The menuItems
     */
    public LinkedHashMap<String, Runnable> getMenuItems() {
        return this.menuItems;
    }

    /**
     * Setter for menuItems
     *
     * @param menuItems The menuItems
     */
    public void setMenuItems(LinkedHashMap<String, Runnable> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Getter for scanner
     *
     * @return The scanner
     */
    public static Scanner getScanner() {
        return ConsoleApplication.scanner;
    }

    /**
     * Setter for scanner
     *
     * @param scanner The scanner
     */
    public static void setScanner(Scanner scanner) {
        ConsoleApplication.scanner = scanner;
    }

    /**
     * Getter for selection
     *
     * @return The selection
     */
    public int getSelection() {
        return this.selection;
    }

    /**
     * Setter for selection
     *
     * @param selection The selection
     */
    public void setSelection(int selection) {
        this.selection = selection;
    }

    /**
     * Getter for header
     *
     * @return The header
     */
    public String getHeader() {
        return this.header;
    }

    /**
     * Setter for header
     *
     * @param header The header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Getter for footer
     *
     * @return The footer
     */
    public String getFooter() {
        return this.footer;
    }

    /**
     * Setter for footer
     *
     * @param footer The footer
     */
    public void setFooter(String footer) {
        this.footer = footer;
    }

    /**
     * Getter for loopApp
     *
     * @return The loopApp
     */
    public boolean isLoopApp() {
        return this.loopApp;
    }

    /**
     * Setter for loopApp
     *
     * @param loopApp The loopApp
     */
    public void setLoopApp(boolean loopApp) {
        this.loopApp = loopApp;
    }

    /**
     * Adds a new menu item
     *
     * @param item     The text of the menu item
     * @param runnable The function which will be executed if the menu item is selected
     */
    public void addMenuItem(String item, Runnable runnable) {
        this.menuItems.put(item, runnable);
    }

    /**
     * Shows the value and prompts for selection
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
                this.selection = ConsoleApplication.scanner.nextInt();
            } catch (InputMismatchException exception) {
                this.selection = 0;
                ConsoleApplication.scanner.next();
            }
        } while (this.selection > this.menuItems.size() || this.selection < 1);

        System.out.println();
    }

    /**
     * Runs the user selected menu item
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
     * Securely reads a integer value from the commandline and user to reenter the value on wrong input
     *
     * @param text       The prompt text
     * @param expression Will be executed to validate the input
     * @return Securely read integer value
     */
    public static int readInt(String text, Function<Integer, Boolean> expression) {
        int value;
        boolean threwException;

        do {
            System.out.print(text);
            try {
                value = ConsoleApplication.scanner.nextInt();
                threwException = false;
            } catch (InputMismatchException exception) {
                value = 0;
                ConsoleApplication.scanner.next();
                threwException = true;
            }
        } while (threwException || !expression.apply(value));

        return value;
    }

    /**
     * Securely reads a double value from the commandline and user to reenter the value on wrong input
     *
     * @param text       The prompt text
     * @param expression Will be executed to validate the input
     * @return Securely read double value
     */
    public static double readDouble(String text, Function<Double, Boolean> expression) {
        double value;
        boolean threwException;

        do {
            System.out.print(text);
            try {
                value = ConsoleApplication.scanner.nextInt();
                threwException = false;
            } catch (InputMismatchException exception) {
                value = 0;
                ConsoleApplication.scanner.next();
                threwException = true;
            }
        } while (threwException || !expression.apply(value));

        return value;
    }

    /**
     * Securely reads a string value from the commandline and user to reenter the value on wrong input
     *
     * @param text       The prompt text
     * @param expression Will be executed to validate the input
     * @return Securely read string value
     */
    public static String readString(String text, Function<String, Boolean> expression) {
        String value;

        do {
            System.out.print(text);

            value = ConsoleApplication.scanner.next();

        } while (!expression.apply(value));

        return value;
    }

    /**
     * Terminates the app
     */
    public void terminate() {
        this.terminate(false);
    }

    /**
     * Terminates the app
     *
     * @param pauseOnTerminate If true the app awaits a final terminating keyboard input
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
     * Starts the app
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
