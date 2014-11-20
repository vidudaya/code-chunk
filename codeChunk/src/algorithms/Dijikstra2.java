package algorithms; 
 

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 *
 */
public class Dijikstra2 {

    public static int[][] edges = new int[120][120];
    public static boolean seen[] = new boolean[10];
    public static int color[];
    public static int n = 0, num = 0;
    public static int parent[];
    public static int distance[];
    //public static PriorityQueue<Integer> vertexQueue = new PriorityQueue<Integer>();
    public static PriorityQueue<Integer> vertexQueue;
    public static int mindist = Integer.MAX_VALUE;

    public void dijkstra(int s) {

        distance[s] = 0;
        vertexQueue.add(s);

        while (!vertexQueue.isEmpty()) {
            int u = vertexQueue.poll();

            for (int v = 0; v <= n; ++v) {
                if (edges[u][v] != -1) {

                    int newdest = distance[u] + edges[u][v];

                    if (newdest < distance[v]) {
                        vertexQueue.remove(v);
                        distance[v] = newdest;
                        vertexQueue.add(v);

                    }
                    System.out.println(Arrays.toString(vertexQueue.toArray()));
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
        System.out.println("kjjkjkjk");
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        for (int i = 0; i < e; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u][v] = sc.nextInt();
        }

        System.out.println("kjkjkj");
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

        vertexQueue = new PriorityQueue<Integer>(n, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1 "+o1+"  o2 "+o2);
                // System.out.println(Arrays.toString(vertexQueue.toArray())+"     *******");
                if (distance[o1] <= distance[o2]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });


        new Dijikstra2().dijkstra(1);
        System.out.println("");
        //System.out.println(Arrays.toString(seen));
        //System.out.println(Arrays.toString(color));
        //System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(distance));
    }
}
