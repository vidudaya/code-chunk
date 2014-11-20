package algorithms; 
/*
 * to a undirected  graph this will give a solution to the reachability problem
 *  // can also check wheter the graph is connected or not.
 */
 

import java.util.Arrays;
import java.util.Scanner;

 
public class DFS1 {

    public static boolean[][] edges = new boolean[120][120];
    public static boolean seen[] = new boolean[10];
    public static int n = 0;

    public void dfs(int u) {
        seen[u] = true;
        for (int i = 0; i <= n; ++i) {
            if (!seen[i] && edges[u][i]) {
                dfs(i);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();// number of vertices
        int e = sc.nextInt();// number of edges
        seen = new boolean[n+1];

        for (int i = 0; i < e; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u][v] = true;
            edges[v][u] = true;
        }

        for(int i=0;i<=n;++i){
            for(int j=0;j<=n;++j){
                System.out.print(" "+edges[i][j]);
            }
            System.out.println("");
        }
        
        new DFS1().dfs(1);
        System.out.println("");
        System.out.println(Arrays.toString(seen));
    }
}
