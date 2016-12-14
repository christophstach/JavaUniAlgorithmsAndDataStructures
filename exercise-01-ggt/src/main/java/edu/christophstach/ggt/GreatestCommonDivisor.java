package edu.christophstach.ggt;

/**
 * @author Christoph Stach - s0555912@htw-berlin.de
 * @since 18.10.2016
 */
public class GreatestCommonDivisor {
    /**
     * Berechnet den gr&ouml;&szlig;ten gemeinsamen Teiler &uuml;ber den Divisionsrest Iterativ
     *
     * @param a Erster Wert
     * @param b Zweiter Wert
     * @return Gr&ouml;&szlig;ter gemeinsamer Teiler
     */
    public static int divisionRestIt(int a, int b) {
        int h;

        while (b != 0) {
            h = a % b;
            a = b;
            b = h;
        }

        return a;
    }

    /**
     * Berechnet den gr&ouml;&szlig;ten gemeinsamen Teiler &uuml;ber den Divisionrest Rekursiv
     *
     * @param a Erster Wert
     * @param b Zweiter Wert
     * @return Gr&ouml;&szlig;ter gemeinsamer Teiler
     */
    public static int divisionRestRec(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GreatestCommonDivisor.divisionRestRec(b, a % b);
        }
    }

    /**
     * Berechnet den gr&ouml;&szlig;ten gemeinsamen Teiler &uuml;ber den Euklidischen Algorithmus iterativ
     *
     * @param a Erster Wert
     * @param b Zweiter Wert
     * @return Gr&ouml;&szlig;ter gemeinsamer Teiler
     */
    public static int euclidIt(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            while (b != 0) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }

            return a;
        }
    }

    /**
     * Berechnet den gr&ouml;&szlig;ten gemeinsamen Teiler &uuml;ber den Euklidischen Algorithmus rekursiv
     *
     * @param a Erster Wert
     * @param b Zweiter Wert
     * @return Gr&ouml;&szlig;ter gemeinsamer Teiler
     */
    public static int euclidRec(int a, int b) {
        if (b == 0) {
            return a;
        } else if (a == 0) {
            return b;
        } else if (a > b) {
            return GreatestCommonDivisor.euclidRec(a - b, b);
        } else {
            return GreatestCommonDivisor.euclidRec(a, b - a);
        }
    }
}
