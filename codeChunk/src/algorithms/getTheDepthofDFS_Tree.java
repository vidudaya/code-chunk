package algorithms; 
 
import java.util.Arrays;
import java.util.Scanner;

public class getTheDepthofDFS_Tree {

    public static boolean[][] edges = new boolean[120][120];
    public static boolean seen[] = new boolean[10];
    public static int n = 0;
    public static int distance[];

    public void dfs(int u, int depth) {
        seen[u] = true;
        distance[u] = depth;
        for (int i = 0; i <= n; ++i) {
            if (!seen[i] && edges[u][i]) {
                dfs(i, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();// number of vertices
        int e = sc.nextInt();// number of edges
        seen = new boolean[n + 1];
        distance = new int[n+1];

        for (int i = 0; i < e; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u][v] = true;
            edges[v][u] = true;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                System.out.print(" " + edges[i][j]);
            }
            System.out.println("");
        }

        new getTheDepthofDFS_Tree().dfs(1,0);
        System.out.println("");
        System.out.println(Arrays.toString(seen));
        System.out.println(Arrays.toString(distance));
    }
}
