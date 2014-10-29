 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author DELL
 */
public class RangeMaxMinTreeSegment {
}

class Main {

    private static int n, q, treeSize;
    private static int[] b, minTree, maxTree;

    private static int createMinTree(int startIndex, int endIndex, int currentPos) {
        if (startIndex == endIndex) {
            return minTree[currentPos] = b[startIndex];
        }
        int mid = (startIndex + endIndex) / 2;
        return minTree[currentPos] = Math.min(createMinTree(startIndex, mid, currentPos * 2 + 1),
                createMinTree(mid + 1, endIndex, currentPos * 2 + 2));
    }

    private static int createMaxTree(int startIndex, int endIndex, int currentPos) {
        if (startIndex == endIndex) {
            return maxTree[currentPos] = b[startIndex];
        }
        int mid = (startIndex + endIndex) / 2;
        return maxTree[currentPos] = Math.max(createMaxTree(startIndex, mid, currentPos * 2 + 1),
                createMaxTree(mid + 1, endIndex, currentPos * 2 + 2));
    }

    private static int queryMinTree(int currentStartIndex, int currentEndIndex,
            int startQueryIndex, int endQueryIndex, int index) {
        if (startQueryIndex <= currentStartIndex && endQueryIndex >= currentEndIndex) {
            return minTree[index];
        }

        if (endQueryIndex < currentStartIndex || startQueryIndex > currentEndIndex) {
            return Integer.MAX_VALUE;
        }

        int mid = (currentStartIndex + currentEndIndex) / 2;
        return Math.min(queryMinTree(currentStartIndex, mid, startQueryIndex, endQueryIndex, index * 2 + 1),
                queryMinTree(mid + 1, currentEndIndex, startQueryIndex, endQueryIndex, index * 2 + 2));
    }

    private static int queryMaxTree(int currentStartIndex, int currentEndIndex,
            int startQueryIndex, int endQueryIndex, int index) {
        if (startQueryIndex <= currentStartIndex && endQueryIndex >= currentEndIndex) {
            return maxTree[index];
        }

        if (endQueryIndex < currentStartIndex || startQueryIndex > currentEndIndex) {
            return -1;
        }

        int mid = (currentStartIndex + currentEndIndex) / 2;
        return Math.max(queryMaxTree(currentStartIndex, mid, startQueryIndex, endQueryIndex, index * 2 + 1),
                queryMaxTree(mid + 1, currentEndIndex, startQueryIndex, endQueryIndex, index * 2 + 2));
    }

    private static int queryMax(int startIndex, int endIndex) {
        return queryMaxTree(0, n - 1, startIndex, endIndex, 0);
    }

    private static int queryMin(int startIndex, int endIndex) {
        return queryMinTree(0, n - 1, startIndex, endIndex, 0);
    }

    private static void createSegmentTree() {
        int heightOfTree = (int) Math.ceil(Math.log(n) / Math.log(2));
        treeSize = 2 * (int) Math.pow(2, heightOfTree) - 1;
        minTree = new int[treeSize];
        maxTree = new int[treeSize];
        createMinTree(0, n - 1, 0);
        createMaxTree(0, n - 1, 0);
    }

    public static void main(String... args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        b = new int[n];
        StringTokenizer stok = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i) {
            b[i] = Integer.parseInt(stok.nextToken());
        }
        createSegmentTree();
        q = Integer.parseInt(in.readLine());
        int startIndex, endIndex;
        for (int i = 0; i < q; ++i) {
            stok = new StringTokenizer(in.readLine());
            startIndex = Integer.parseInt(stok.nextToken());
            endIndex = Integer.parseInt(stok.nextToken());
            int minBurningTime = queryMin(startIndex, endIndex);
            int maxBurningTime = queryMax(startIndex, endIndex);
            int maxNonBurningTime = Math.max((startIndex > 0) ? queryMax(0, startIndex - 1) : -1,
                    (endIndex < n - 1) ? queryMax(endIndex + 1, n - 1) : -1);
            double ans1 = (double) (maxBurningTime - minBurningTime) / 2;
            double ans2 = maxNonBurningTime;
            System.out.printf("%.1f\n", (ans1 > ans2) ? ans1 + minBurningTime : ans2 + minBurningTime);
        }
        System.exit(0);
    }
}
