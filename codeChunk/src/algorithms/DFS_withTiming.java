 

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DFS_withTiming {

    public static Node[] nodes;
    public static int[] parent;
    public static int[] seen;
    public static int[] d;// disover time
    public static int[] f;// finished time
    public static int time = 0;
    public static int n = 0;

    public static void solve() {
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String s[];
        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        nodes = new Node[n];
        parent = new int[n];// zero based system
        seen = new int[n];// zero based system
        d = new int[n];// zero based system
        f = new int[n];// zero based system

        for (int i = 0; i < n; i++) {
            parent[i] = -1;// no parent yet
            seen[i] = 0;// unvisited
            nodes[i] = new Node(i);// make a node
        }

        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);

            nodes[u].addNeighbour(nodes[v]);
            nodes[v].addNeighbour(nodes[u]);

        }
        dfs();

        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(f));

    }

    public static void dfs() {
        for (int i = 0; i < n; i++) {
            if (seen[i] == 0) {
                dfs_visit(i);
                System.out.println(Arrays.toString(seen));
            }
        }
    }

    public static void dfs_visit(int u) {
        time = time + 1;
        d[u] = time;// visited time
        seen[u] = 1;// mark u as visited

        for (int i = 0; i < nodes[u].neighbours.size(); i++) {
            int v = nodes[u].neighbours.get(i).number;
            if (seen[v] == 0) {
                parent[v] = u;
                dfs_visit(v);
            }
        }
        time = time + 1;
        f[u] = time;
    }
}
class Node {

    int number;
    ArrayList<Node> neighbours = new ArrayList<Node>();

    public Node(int number) {
        this.number = number;
    }

    public void addNeighbour(Node node) {
        neighbours.add(node);
    }
}