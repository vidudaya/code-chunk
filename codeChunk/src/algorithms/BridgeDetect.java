 

 
import java.util.Arrays;
import java.util.Scanner;

 
public class BridgeDetect {

    public static boolean[][] edges = new boolean[120][120];
    public static boolean seen[] = new boolean[10];
    public static int color[];
    public static int n = 0, num = 0;
    public static int dfsNum[];
    public static int parent[];

    public int dfs(int u, int p) {
        parent[u] = p;
        color[u] = 1;
        dfsNum[u] = num++;
        int leastAncestor = num;

        for (int v = 0; v <= n; ++v) {
            if (edges[u][v] && v != p) {
                if (color[v] == 0) {// (u,v) is a forward edge

                    int rec = dfs(v, u);

                    if (rec > dfsNum[u]) {// least ansestor of v is greater than that of u
                        // means there is no vertex below u which in the DFS tree that connected  to a vertex in upper 
                        //tree ,  by an edge
                        System.out.println("Bridge : (" + u + " , " + v + ")");
                    }

                    leastAncestor = Math.min(leastAncestor, rec);
                } else {  //(u,v) is a back edge
                    leastAncestor = Math.min(leastAncestor, dfsNum[v]);
                }
            }
        }

        color[u] = 2;
        return leastAncestor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();// number of vertices
        int e = sc.nextInt();// number of edges
        seen = new boolean[n + 1];
        color = new int[n + 1];
        dfsNum = new int[n + 1];
        parent = new int[n + 1];
        num = 1;



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

       // new BridgeDetect().dfs(1, -1);
        new BridgeDetect().dfs(1, -1);
        System.out.println("");
        //System.out.println(Arrays.toString(seen));
        System.out.println(Arrays.toString(color));
        System.out.println(Arrays.toString(dfsNum));
        System.out.println(Arrays.toString(parent));
    }
}
