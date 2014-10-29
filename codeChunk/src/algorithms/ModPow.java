 
 
public class ModPow {

    static long modPow(long a, long x, long p) {
        //calculates a^x mod p in logarithmic time.
        long res = 1;
        while (x > 0) {
            if (x % 2 != 0) {
                res = (res % p * a % p) % p;
            }
            a = (a % p * a % p) % p;
            x /= 2;
        }
        return res;
    }

    static long modInverse(long a, long p) {
        //calculates the modular multiplicative of a mod m.
        //(assuming p is prime).
        return modPow(a, p - 2, p);
    }

    static long modBinomial(long n, long k, long p) {
        // calculates C(n,k) mod p (assuming p is prime).

        long numerator = 1; // n * (n-1) * ... * (n-k+1)
        for (long i = 0; i < k; i++) {
            numerator = (numerator % p * (n - i) % p) % p;
        }

        long denominator = 1; // k!
        for (long i = 1; i <= k; i++) {
            denominator = (denominator % p * i % p) % p;
        }

        // numerator / denominator mod p.
        return (numerator % p * modInverse(denominator, p) % p) % p;
    }

    public static long calculate(long k, long n) {
        return (modBinomial(n, k, 1000000007));
    }
}
