import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author s0555912@htw-berlin.de<Christoph Stach>
 * @since 18.10.2016
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. EuclidIt");
        System.out.println("2. EuclidRec");
        System.out.println("3. DivisionRestIt");
        System.out.println("4. DivisionRestRec");
        System.out.println("");

        System.out.print("Bitte geben Sie Ihre Auswahl ein: ");
        int selection = scanner.nextInt();

        while (selection > 4 || selection < 1) {
            System.out.print("Bitte geben Sie eine Wert von 1-4 ein: ");
            selection = scanner.nextInt();
        }

        System.out.print("Bitte geben Sie eine Wert fuer A ein: ");
        int numberA = scanner.nextInt();

        System.out.print("Bitte geben Sie eine Wert fuer B ein: ");
        int numberB = scanner.nextInt();

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

        scanner.close();
    }
}
