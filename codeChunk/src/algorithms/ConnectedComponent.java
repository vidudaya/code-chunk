package algorithms; 

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConnectedComponent {

    static class DisjointSets {

        int[] parent; // parent of each node
        int[] size; // how many are in the same set (same tree)

        public DisjointSets(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i]=1;
            }
        }
        // this will check two  nodes are belongs to the same  set or not

        public boolean isSameSet(int first, int second) {
            return findparent(first) == findparent(second);
        }

        // this will also find the parent of a given node
        int findparent(int index) {

            if (parent[index] == index) {
                return index;
            } else {
                return parent[index] = findparent(parent[index]);
            }

        }
        // use this if want to calculate the number of connected components only
        // this can't tell how many are in the same component (size of each component)

        void union(int first, int second) {
            parent[findparent(first)] = findparent(second);
        }
        ///////////////////////////////////////////
        // use this if want to calculate the number of connected components and
        //  the size of each component

        void uni(int u, int v) {
            int r1 = findP(u);
            int r2 = findP(v);
            if (r1 != r2) {
               // System.out.println("jjj");
                if (size[r1] < size[r2]) {
                    int temp = r1;
                    r1 = r2;
                    r2 = temp;
                }
                parent[r2] = r1;
                size[r1] = size[r1] + size[r2];
                size[r2] = 1;// becasue now r2 is not a root of a tree / the tree belongs to r2 joind to r1's
                //System.out.println(Arrays.toString(size));
            }
        }

        // this will find the parent of a node
        int findP(int index) {//v
            while (parent[index] != index) {
                index = parent[index];
            }
            return index;
        }

        ///////////////////////////////////////////
        // this will count the number of connected components
        int noOfConnectedComp() {
            System.out.println(Arrays.toString(parent));
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(buff.readLine());
//        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
//
//        @SuppressWarnings("unchecked")
//        ArrayList<Integer>[] langs = new ArrayList[m];
//        for (int i = 0; i < m; i++) {
//            langs[i] = new ArrayList<Integer>();
//        }
//
//        boolean wa7d3aref = false;
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(buff.readLine());
//            int count = Integer.parseInt(st.nextToken());
//
//            if (count != 0) {
//                wa7d3aref = true;
//            }
//            for (int j = 0; j < count; j++) {
//                langs[Integer.parseInt(st.nextToken()) - 1].add(i);
//                // langs[Integer.parseInt(st.nextToken())].add(i);
//            }
//        }
//
//        DisjointSets dis = new DisjointSets(n);
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < langs[i].size() - 1; j++) {
//                dis.union(langs[i].get(j), langs[i].get(j + 1));
//            }
//        }
//
//        int ans = dis.noOfConnectedComp();
//        if (wa7d3aref) {
//            System.out.println(ans - 1);
//        } else {
//            System.out.println(ans);
//        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("100000.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; ++i) {
            Runtime.getRuntime().gc();
            st = new StringTokenizer(br.readLine());
            // int N = Integer.parseInt(st.nextToken()) + 1;// +1 ans will increase by 1
            int N = Integer.parseInt(st.nextToken());// +1 ans will increase by 1
            int M = Integer.parseInt(st.nextToken());
            if (M == 0) {
                System.out.println(N + " " + 1);
                continue;
            }
            DisjointSets dis = new DisjointSets(N);
            System.out.println("$$$$$$$");
            for (int j = 0; j < M; ++j) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                // int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken()) - 1;
                // int v = Integer.parseInt(st.nextToken());


                dis.uni(u, v);//check v,u also
                //dis.union(u, v);//check v,u also
                System.out.println(Arrays.toString(dis.parent) + " u v = " + (u) + " " + v);
            }
            System.out.println("@@@ = "+Arrays.toString(dis.size));
            long ans = dis.noOfConnectedComp();
            // long led = dis.numberOfLed();
            // System.out.println("ans = " + ans + " leader =        " + led);
            // System.out.println(ans + " " + led);

            // pw.write(ans + " " + led + "\n");
            pw.write("" + ans + "\n");
            pw.flush();
        }

        pw.flush();

        pw.close();
    }
}