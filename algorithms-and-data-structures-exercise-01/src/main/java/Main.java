import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        int selection, numberA, numberB;

        System.setProperty("console.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. EuclidIt");
        System.out.println("2. EuclidRec");
        System.out.println("3. DivisionRestIt");
        System.out.println("4. DivisionRestRec");
        System.out.println("");

        do {
            System.out.print("Bitte geben Sie eine ganzzahligen Wert von 1-4 ein: ");
            try {
                selection = scanner.nextInt();
            } catch (InputMismatchException exception) {
                selection = 0;
                scanner.next();
            }
        } while (selection > 4 || selection < 1);

        do {
            System.out.print("Bitte geben Sie einen ganzzahligen Wert > 0 fuer A  ein: ");
            try {
                numberA = scanner.nextInt();
            } catch (InputMismatchException exception) {
                numberA = 0;
                scanner.next();
            }
        } while (numberA < 1);

        do {
            System.out.print("Bitte geben Sie einen ganzzahligen Wert > 0 fuer B  ein: ");
            try {
                numberB = scanner.nextInt();
            } catch (InputMismatchException exception) {
                numberB = 0;
                scanner.next();
            }
        } while (numberB < 1);


        switch (selection) {
            case 1:
                System.out.println("EuclidIt(" + numberA + ", " + numberB + ") = " + GreatestCommonDivisor.euclidIt(numberA, numberB));
                break;
            case 2:
                System.out.println("EuclidRec(" + numberA + ", " + numberB + ") = " + GreatestCommonDivisor.euclidRec(numberA, numberB));
                break;
            case 3:
                System.out.println("DivisionRestIt(" + numberA + ", " + numberB + ") = " + GreatestCommonDivisor.divisionRestIt(numberA, numberB));
                break;
            case 4:
                System.out.println("DivisionRestRec1(" + numberA + ", " + numberB + ") = " + GreatestCommonDivisor.divisionRestRec(numberA, numberB));
                break;
        }

        System.out.print("\n\n\nDruecken Sie eine beliebige Taste um das Programm zu beenden...");

        try {
            System.in.read();
        } catch (IOException exception) {

        }

        System.out.println("");
        scanner.close();
    }
}
