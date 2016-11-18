package exercise;

import exercise.util.ConsoleApplication;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class Application {
    /**
     * Haupt methode
     *
     * @param args commandline args
     */
    public static void main(String[] args) {
        ConsoleApplication app = new ConsoleApplication();

        app.addMenuItem("EuclidIt", () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("\nEuclidIt(" + a + ", " + b + ") = " + GreatestCommonDivisor.euclidIt(a, b));
        });

        app.addMenuItem("EuclidRec", () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("\nEuclidRec(" + a + ", " + b + ") = " + GreatestCommonDivisor.euclidRec(a, b));
        });

        app.addMenuItem("DivisionRestIt", () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("\nDivisionRestIt(" + a + ", " + b + ") = " + GreatestCommonDivisor.divisionRestIt(a, b));
        });

        app.addMenuItem("DivisionRestRec", () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("\nDivisionRestRec(" + a + ", " + b + ") = " + GreatestCommonDivisor.divisionRestRec(a, b));
        });

        app.setLoopApp(true);
        app.setHeader("" +
            "Wilkommen beim groesten gemeinsamen Teiler\n" +
            "------------------------------------------\n"
        );
        app.run();
        app.terminate(true);
    }
}
