package algorithms;

 
/**
 *
 * @author DELL
 */
public class Calculate1sInBinaryFormOfInt {

    public static int d(long n) {
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans + 1;
            }
            n = n / 2;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
        System.out.println(d(12));
    }
}
