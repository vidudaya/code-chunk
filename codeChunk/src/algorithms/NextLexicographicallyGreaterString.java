package algorithms; 

import java.io.*;

/**
 *
 * @author DELL
 */
public class NextLexicographicallyGreaterString {

    public static boolean hik = false;
    public static StringBuilder sbb;

    public static void solve(char[] a, int n) {
        int k = -1, l = -1;
        for (int i = n; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            return;
        }
        for (int i = k + 1; i < a.length; i++) {
            if (a[k] < a[i]) {
                l = i;
            }
        }
        char temp = a[k];
        a[k] = a[l];
        a[l] = temp;
        hik = true;

        sbb = new StringBuilder();
        for (int i = 0; i <= k; i++) {
            sbb.append(a[i]);
        }
        for (int i = a.length - 1; i > k; i--) {
            sbb.append(a[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter f0 = new PrintWriter(new OutputStreamWriter(System.out));
        // PrintWriter f0 = new PrintWriter(new FileOutputStream("out.txt"));

        int t = toInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        A:
        for (int i = 0; i < t; i++) {
            char c[] = br.readLine().toCharArray();
            hik = false;
            solve(c, 0);
            if (hik) {
                sb.append(sbb.toString() + "\n");
                // System.out.println(sbb.toString());
            } else {
                sb.append("no answer\n");
                //System.out.println("no answer");
            }

        }
        System.out.println(sb.toString());
        // f0.append(sb.toString().trim());
        // f0.flush();
    }

    public static Integer toInt(String s) {
        return Integer.parseInt(s.trim());
    }
}
