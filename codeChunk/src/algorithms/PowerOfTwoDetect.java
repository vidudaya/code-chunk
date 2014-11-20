package algorithms; 

import java.math.BigInteger;

/**
 *
 * @author DELL
 */
public class PowerOfTwoDetect {
    public static boolean isBigPowerOfTwo(BigInteger x) {

        if (!x.equals(new BigInteger("0")) && ((x.and(x.not().add(new BigInteger("1")))).equals(x))) {
            return true;
        }
        return false;
    }

    public static boolean isPowerOfTwo(int x) {
        return ((x != 0) && ((x & (~x + 1)) == x));
    }
}
