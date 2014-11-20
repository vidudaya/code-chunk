package algorithms;/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */


/**
 *
 * @author DELL
 */
public class MaximumValueContiguousSubSequence {

    public static void MVCSC(int a[]) {

        int i = 0;

        int dp[] = new int[a.length];
        dp[0] = a[0];
        for (i = 1; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }

        i = 0;
        while (i < a.length) {
            System.out.print(dp[i] + " ");
            ++i;
        }
        System.out.println("\nMaximum out of these numbers will be the MVCSC");

    }

    public static void main(String[] args) {
        int a[] = {0, -1, 2, -3, 4, 5, -1};
        MVCSC(a);
    }
}
