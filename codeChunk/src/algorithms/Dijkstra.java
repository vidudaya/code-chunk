package algorithms; 
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Not using the priority queue  to select the minimum distance vertex
 */
public class Dijkstra {

    public static int[][] edges = new int[120][120];
    public static boolean seen[] = new boolean[10];
    public static int color[];
    public static int n = 0, num = 0;
    public static int parent[];
    public static int distance[];
    public static PriorityQueue<Integer> vertexQueue = new PriorityQueue<Integer>();

    public static int mindist=Integer.MAX_VALUE;
    
    public void dijkstra(int s) {

        distance[s] = 0;         
        vertexQueue.add(s);

        while (!vertexQueue.isEmpty()) {
            int u = vertexQueue.poll();
            
            
          //  System.out.println("u= " + u + "  dist u = " + distance[u]);
            for (int v = 0; v <= n; ++v) {
                if (edges[u][v] != -1) {
                    //System.out.println("kkk");
                    int newdest = distance[u] + edges[u][v];
                    //System.out.println("v= "+v  +"  newdest = " + newdest);
                    if (newdest < distance[v]) {
                        vertexQueue.remove(v);
                        distance[v] = newdest;
                        vertexQueue.add(v);
                        System.out.println(Arrays.toString(vertexQueue.toArray()));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();// number of vertices
        int e = sc.nextInt();// number of edges
        seen = new boolean[n + 1];
        color = new int[n + 1];
        parent = new int[n + 1];
        distance = new int[n + 1];
        num = 1;

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        for (int i = 0; i < e; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u][v] = sc.nextInt();
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (edges[i][j] != 0) {
                    System.out.print(" " + edges[i][j]);
                } else if (edges[i][j] == 0) {
                    edges[i][j] = -1;
                    System.out.print(" ----");
                }
            }
            System.out.println("");
        }

        new Dijkstra().dijkstra(1);
        System.out.println("");
        //System.out.println(Arrays.toString(seen));
        //System.out.println(Arrays.toString(color));
        //System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(distance));
    }
}
