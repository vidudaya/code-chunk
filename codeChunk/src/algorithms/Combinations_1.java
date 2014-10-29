 

/**
 *
 * @author DELL
 */
public class Combinations_1 {

    static long C(long n, long k) {
        double res = 1;
        for (long i = 1; i <= k; ++i) {
            res = res * (n - k + i) / i;
        }
        return (long) (res + 0.01);
    }

    static long CC(long n, long k) {
        long r = 1;
        long d;
        if (k > n) {
            return 0;
        }
        for (d = 1; d <= k; d++) {
            r *= n--;
            r /= d;
        }
        return r;
    }
    
    static long P(long n,long k){
        double res =1;
        for (long i = n; i > n-k; i--) {
            res*=i;
        }
        return (long)res;
    }

    public static void main(String[] args) {
        System.out.println(C(4,2));
        System.out.println(P(4,2));
    }
}
