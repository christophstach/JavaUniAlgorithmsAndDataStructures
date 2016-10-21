/**
 * @author s0555912@htw-berlin.de<Christoph Stach>
 * @since 18.10.2016
 */
public class GreatestCommonDivisor {
    /**
     * Berechnet den größten gemeinsamen Teiler über den Divisionsrest Iterativ
     *
     * @param a
     * @param b
     * @return
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
     * Berechnet den größten gemeinsamen TEiler über den Divisionrest Rekursiv
     *
     * @param a
     * @param b
     * @return
     */
    public static int divisionRestRec(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GreatestCommonDivisor.divisionRestRec(b, a % b);
        }
    }

    /**
     * Berechnet den größten gemeinsamen Teiler über den Euklidischen Algorithmus iterativ
     *
     * @param a
     * @param b
     * @return
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
     * Berechnet den größten gemeinsamen Teiler über den Euklidischen Algorithmus rekursiv
     *
     * @param a
     * @param b
     * @return
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
