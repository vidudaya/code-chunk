package algorithms; 

/**
 *
 * @author DELL
 */
public class CoinChange {

    public static void makeChange(int wgt[], int c) {
        int n = wgt.length, S = c+1; //n - number of coin types, S - desired overall weight
//int wgt[MAXN]; //array of coin weights (W); for example: {1, 3, 5};
        int mink[] = new int[c+1]; //array of DP results (k); look above for the example;
        mink[0] = 0; //base of DP: 0 weight can be achieved by 0 coins
        for (int P = 1; P < S; P++) { //iterate through all the states
            int minres = 1000000000;
            for (int i = 0; i < n; i++) {
                if (wgt[i] <= P) { //suppose that the coin with weight wgt[i] is the last
                    int tres = mink[P - wgt[i]] + 1; //the number of coins with the coin is greater by one
                    if (minres > tres) {
                        minres = tres; //choose the minimal overall number of coins among all cases
                    }
                }
            }
            mink[P] = minres; //store the result in mink array
        }
        int i=0;
        while(i<mink.length){
            System.out.print(mink[i]+" ");
            ++i;
        }
        System.out.println("");
        int answer = mink[S-1];
        System.out.println(answer);
        
        
    }

    public static void main(String[] args) {
        int v[] = {1,30,5};
        int c = 7;

        makeChange(v, c);
    }
}
