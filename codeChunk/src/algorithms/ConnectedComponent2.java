 

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectedComponent2 {

    public static int[] O;//O[i] is the depth for node i in the dfs tree
    public static int[] L;//L[i] the lowest depth of neighbors of all descendants of node i in the depth-first-search tree 
    public static int[] P;//parent
    public static int[][] g;
    public static boolean[] art;
    public static boolean[][] gg;
    public static int o = 0;

    public static void dfs(int v, int p) {
        // p = -1; only for the first time
        O[v] = L[v] = ++o;
        P[v] = p;
        int si = g[v].length;
        int ch = 0;
        for (int i = 0; i < si; i++) {
            if (g[v][i] == 1) {
                //int w = g[v][i];
                int w = i;
                if (w == p) {
                    continue;
                }
                if (O[w] > 0) {//if(O[w])
                    L[v] = Math.min(L[v], O[w]);
                } else {
                    ch++;
                    dfs(w, v);
                    L[v] = Math.min(L[v], L[w]);
                    if (L[w] >= O[v]) {
                        art[v] = true;
                    }
                }
            }
        }
        if (p == -1 && ch < 2) {
            art[v] = false;
        }
    }

    public static void dfs2(int v, int p) {
        // p = -1; only for the first time
        O[v] = L[v] = ++o;
        P[v] = p;
        int si = g[v].length;
        int ch = 0;
        for (int i = 0; i < si; i++) {

            int w = g[v][i];
            if (w == p) {
                continue;
            }
            if (O[w] > 0) {//if(O[w])
                L[v] = Math.min(L[v], O[w]);
            } else {
                ch++;
                dfs(w, v);
                L[v] = Math.min(L[v], L[w]);
                if (L[w] >= O[v]) {
                    art[v] = true;
                }
            }
        }
        if (p == -1 && ch < 2) {
            art[v] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s[];
        s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        O = new int[n];
        L = new int[n];
        P = new int[n];
        art = new boolean[n];
        gg = new boolean[n][n];
        g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = -1;
            }
        }
        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0])-1;
            int v = Integer.parseInt(s[1])-1;

            g[u][v] = 1;
            g[v][u] = 1;
        }
        dfs(0, -1);
        System.out.println(Arrays.toString(art));
        int count =0;
        for (int i = 0; i < n; i++) {
            if(art[i]){
                count++;
            }
        }
        System.out.println(count);

    }
}
