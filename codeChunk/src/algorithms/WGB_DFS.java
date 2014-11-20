package algorithms; 

 
import java.util.Arrays;
import java.util.Scanner;

 
public class WGB_DFS {

    public static boolean[][] edges = new boolean[120][120];
    public static boolean seen[] = new boolean[10];
    public static int color[];
    public static int n = 0, num = 0;
    public static int dfsNum[];
    public static int parent[];

    //p = parent of u
    public void dfs(int u, int p) {
        color[u] = 1; // 1 = gray,2=black,0=white
        dfsNum[u] = num++;

        parent[u] = p;

        for (int v = 0; v <= n; ++v) {
            if (edges[u][v] && v != p) {

                if (color[v] == 0) {// (u,v) is a  forward edge
                    dfs(v, u);
                } else if (color[v] == 1) {
                    // (u,v) is a back edge
                } else if (color[v] == 2) {
                    // (u,v) is a cross edge
                }
            }
        }

        color[u] = 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();// number of vertices
        int e = sc.nextInt();// number of edges
        seen = new boolean[n + 1];
        color = new int[n + 1];
        dfsNum = new int[n + 1];
        parent = new int[n + 1];
        num = 0;


        for (int i = 0; i < e; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u][v] = true;
            edges[v][u] = true;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (edges[i][j]) {
                    System.out.print(" " + edges[i][j]);
                } else {
                    System.out.print(" ----");
                }
            }
            System.out.println("");
        }

        new WGB_DFS().dfs(0, -1);
        System.out.println("");
        //System.out.println(Arrays.toString(seen));
        System.out.println(Arrays.toString(color));
        System.out.println(Arrays.toString(dfsNum));
        System.out.println(Arrays.toString(parent));
    }
}
