 

/**
 *
 * @author DELL
 */
public class PrimeDetect {

    public static boolean solve(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        int i = 2;
        double a = Math.sqrt(Math.abs(n));
        while (i <= a) {
            if (n % i == 0) {
                return false;
            }
            ++i;
        }
        return true;
    }
}
