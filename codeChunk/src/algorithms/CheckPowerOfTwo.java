 

import java.io.*;
import java.math.BigInteger;

/**
 *
 * @author DELL
 */
public class CheckPowerOfTwo {

    public static boolean isBigPowerOfTwo(BigInteger x) {

        if (!x.equals(new BigInteger("0")) && ((x.and(x.not().add(new BigInteger("1")))).equals(x))) {
            return true;
        }
        return false;
    }

    public static boolean isPowerOfTwo(int x) {
        return ((x != 0) && ((x & (~x + 1)) == x));
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter f0 = new PrintWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        BigInteger in = new BigInteger(num);
        String temp = in.toString(2);
        //largest power of 2 less than N(temp)  new BigInteger("2").shiftLeft(temp.length() - 2)
       // System.out.println("9<<1  = " + (9 << 1));
        //System.out.println("9<<2  = " + (9 << 2));
       // System.out.println("2<<2  = " + (2 << 1));
      //  System.out.println("temp = " + temp);
        System.out.println(new BigInteger("2").shiftLeft(temp.length() - 2));
        in = in.subtract(new BigInteger("2").shiftLeft(temp.length() - 2));
        //System.out.println(in.toString());
    }
}
