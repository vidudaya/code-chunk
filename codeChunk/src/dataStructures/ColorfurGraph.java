 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ColorfurGraph {

    public void solve() throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int i = 0, j = 0, k = 0;
        int colourV[] = new int[n + 1];
        int maxc = 0;
        for (i = 1; i <= n; ++i) {
            colourV[i] = sc.nextInt();
            if (maxc < colourV[i]) {
                maxc = colourV[i];
            }
        }
        int deg[] = new int[maxc + 1];
        Arrays.fill(deg, -1);
        for (i = 1; i <= n; ++i) {
            deg[colourV[i]] = 0;
        }
        //System.out.println(Arrays.toString(deg));
        Set<edge> set = new HashSet<edge>();


        for (i = 0; i < m; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (colourV[u] != colourV[v]) {
                set.add(new edge(colourV[u], colourV[v]));
            }

        }


        edge[] ed = (edge[]) set.toArray(new edge[set.size()]);
      //  System.out.println(Arrays.toString(ed));
        for (i = 0; i < set.size(); ++i) {
            // System.out.println(ed[i].getU() + "  " + ed[i].getV());
            int u = ed[i].getU();
            int v = ed[i].getV();
            deg[u]++;
            deg[v]++;
        }

        // System.out.println(Arrays.toString(deg));
        int ans = -1, print = 0;
        for (i = 0; i < deg.length; ++i) {
            //System.out.println(deg[i] + "  i " + i + "  ans= " + ans);
            if (ans < deg[i]) {
                ans = deg[i];
                print = i;
            }

        }

        System.out.println(print);


    }

    public static void main(String[] args) throws IOException {
        new ColorfurGraph().solve();

    }
}
class edge {

    public edge(int ua, int va) {
        this.u = ua;
        this.v = va;
    }
    public int u;
    public int v;

    public int getU() {
        return u;
    }

    public void setU(int ua) {
        this.u = ua;
    }

    public int getV() {
        return v;
    }

    public void setV(int va) {
        this.v = va;
    }

    @Override
    public String toString() {

        return "(" + u + " " + v + ")" + " ";
    }

    @Override
    public boolean equals(Object o) {
        int u1 = ((edge) o).getU();
        int v1 = ((edge) o).getV();

       // System.out.println(this.u + " " + v + " " + u1 + " " + v1 + " ");

        if ((u1 == u && v1 == v) || (u1 == v && v1 == u)) {
            return true;
        }else{
            return false;
        }

         
    }

    @Override
    public int hashCode() {
        int hash = 3231;

        return hash;
    }
}
