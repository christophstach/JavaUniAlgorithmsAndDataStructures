/*
 * Copyright (c) 2016 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach.skyline;

import edu.christophstach.util.ConsoleApplication;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 12/14/16
 */
public class Application {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        ConsoleApplication app = new ConsoleApplication();
        app.setLoopApp(true);

        Skyline skyline = new Skyline();

        app.addMenuItem("Testgebaeude zur Skyline hinzufuegen", () -> {
            skyline.addBuilding(new Building(4, 8, 0));
            skyline.addBuilding(new Building(2, 16, 3));
            skyline.addBuilding(new Building(3, 12, 4));
            skyline.addBuilding(new Building(8, 8, 6));
            skyline.addBuilding(new Building(4, 20, 8));
            skyline.addBuilding(new Building(10, 3, 8));

            System.out.println("Test Gebauede hinzugefuegt");
        });

        app.addMenuItem("Gebauede der Skyline hinzufuegen", () -> {
            Building building = new Building();
            building.setPosition(ConsoleApplication.readInt("Bitte die Position (>= 0) eingeben: ", value -> value >= 0));
            building.setHeight(ConsoleApplication.readInt("Bitte die Hoehe (> 0) eingeben: ", value -> value > 0));
            building.setWidth(ConsoleApplication.readInt("Bitte die Breite (> 0) eingeben: ", value -> value > 0));

            skyline.addBuilding(building);
        });

        app.addMenuItem("Skyline ausgeben", () -> {
            System.out.println(skyline);
        });


        app.run();

    }
}

