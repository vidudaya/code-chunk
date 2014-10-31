/*
 * Project Euler #1: Multiples of 3 and 5
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class PE1 {

    public static void main(String[] args) throws IOException {
        new PE1().solve();
    }

    public void solve() throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        int t = toInt(br.readLine());
        long count = 0;


        for (int i = 0; i < t; i++) {
            int n = toInt(br.readLine());
            long a3 = n - 1;
            long a5 = n - 1;
            long a15 = n - 1;
            while (a3 % 3 != 0) {
                a3--;
            }

            long a3n = ((a3 - 3) / 3) + 1;
            count += ((a3n) * (2 * 3 + (a3n - 1) * 3)) / 2;
            while (a5 % 5 != 0) {
                a5--;
            }
            long a5n = ((a5 - 5) / 5) + 1;
            count += ((a5n) * (2 * 5 + (a5n - 1) * 5)) / 2;
            while (a15 % 15 != 0) {
                a15--;
            }
            long a15n = ((a15 - 15) / 15) + 1;
            count -= ((a15n) * (2 * 15 + (a15n - 1) * 15)) / 2;

            System.out.println(count);

            count = 0;
        }
    }

    public static Integer toInt(String s) {
        return Integer.parseInt(s.trim());
    }
}
