 

import java.util.Random;

/**
 *
 * @author vidudaya
 */
public class RandomNumberGenerator {

    public int[] FillArray(int n) {

        Random ran = new Random();
        int i = 0, j = 0;
        int A[] = new int[n];
        while (j < n) {
           
            i=ran.nextInt(1000);
           // System.out.print(i);
            
            A[j] = i;
            j++;

        }
        return A;
    }
    
}
