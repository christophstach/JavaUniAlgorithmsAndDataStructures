/*
 * Copyright (c) 2017 Christoph Stach <christoph.stach@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.christophstach;

import edu.christophstach.hanoi.game.TowersOfHanoi;
import edu.christophstach.skyline.Building;
import edu.christophstach.skyline.Skyline;
import edu.christophstach.util.ConsoleApplication;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 1/9/17
 */
public class Application {
    /**
     * Entry point for the application
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        System.out.println("1. Tuerme von Hanoi");
        System.out.println("2. Skyline Problem\n");

        int selection = ConsoleApplication.readInt("Bitte treffen Sie Ihre Auswahl: ", (value) -> value >= 1 && value <= 2);

        switch (selection) {
            case 1:
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
                break;
            case 2:
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

                app.addMenuItem("Skyline ausgeben", () -> System.out.println(skyline));

                app.run();
                break;
        }

    }
}
