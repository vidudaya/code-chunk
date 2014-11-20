package algorithms; 


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


import java.util.TreeSet;

public class ConnectedComponents3 {

    static class DisjointSets {

        int[] parent;
        int[] size;
        long ledcount = 0;
        boolean got[];
        long mod = 1000000007;

        public DisjointSets(int n) {
// TODO Auto-generated constructor stub
            parent = new int[n];
            size = new int[n];
            got = new boolean[n];
// Arrays.fill(got, false);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean isSameSet(int first, int second) {
// TODO Auto-generated method stub
            return findparent(first) == findparent(second);
        }

        int findparent(int index) {

            if (parent[index] == index) {
                return index;
            } else {
                return parent[index] = findparent(parent[index]);
            }

        }

// long findparentWithCount(int index) {
// ledcount = 1;
// got[index] = true;
// if (parent[index] == index) {
// return ledcount;
// } else {
// return parent[index] = findparent(parent[index]);
// }
//
// }
        void union(int first, int second) {

            parent[findparent(first)] = findparent(second);
        }

        void uni(int u, int v) {
            int r1 = findP(u);
            int r2 = findP(v);
            if (r1 != r2) {
                if (size[r1] < size[r2]) {
                    int temp = r1;
                    r1 = r2;
                    r2 = temp;
                }
                parent[r2] = r1;
                size[r1] = size[r1] + size[r2];
                size[r2] = 1;
            }
        }

        int findP(int index) {//v
            while (parent[index] != index) {
                index = parent[index];
            }
            return index;
        }

        long numberOfLed() {
            long led = 1;
// System.out.println(Arrays.toString(size));
            for (int i = 0; i < got.length; ++i) {
                led = led % mod * size[i] % mod;
// System.out.println(led);
// if (led == 0) {
// System.out.println("wroooong " + i);
// System.exit(0);
// }
            }

            return led % mod;
        }

        int noOfConnectedComp() {
// TODO Auto-generated method stub
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
// System.out.println(Arrays.toString(parent));
            return count;
        }
    }

//@SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("100000.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; ++i) {
            Runtime.getRuntime().gc();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (M == 0) {
                System.out.println(N + " " + 1);
                continue;
            }
            DisjointSets dis = new DisjointSets(N);
//System.out.println("$$$$$$$");
            for (int j = 0; j < M; ++j) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;


                dis.uni(u, v);//check v,u also
//System.out.println(Arrays.toString(dis.parent) + " u v = " + (u) + " " + v);
            }
            long ans = dis.noOfConnectedComp();
            long led = dis.numberOfLed();
// System.out.println("ans = " + ans+" leader = "+led);
// System.out.println(ans + " " + led);

            pw.write(ans + " " + led + "\n");
            pw.flush();
        }
        pw.flush();
        pw.close();


    }
}
