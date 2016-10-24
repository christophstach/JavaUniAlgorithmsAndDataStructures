/**
 *
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class Main {
    /**
     * Haupt methode
     *
     * @param args commandline args
     */
    public static void main(String[] args) {
        ConsoleApplication app = new ConsoleApplication();

        app.addMenuItem("EuclidIt",  () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("EuclidIt(" + a + ", " + b + ") = " + GreatestCommonDivisor.euclidIt(a, b));
        });

        app.addMenuItem("EuclidRec", () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("EuclidRec(" + a + ", " + b + ") = " + GreatestCommonDivisor.euclidRec(a, b));
        });

        app.addMenuItem("DivisionRestIt", () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("DivisionRestIt(" + a + ", " + b + ") = " + GreatestCommonDivisor.divisionRestIt(a, b));
        });

        app.addMenuItem("DivisionRestRec", () -> {
            int a, b;

            a = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ", (value) -> value > 0);
            b = app.readInt("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ", (value) -> value > 0);

            System.out.println("DivisionRestRec(" + a + ", " + b + ") = " + GreatestCommonDivisor.divisionRestRec(a, b));
        });

        app.showMenu();
        app.handleMenuSelection();
        app.terminate();
    }
}
