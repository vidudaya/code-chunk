
import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
 * https://www.hackerrank.com/contests/w12/challenges/favourite-sequence
 */

public class TopologicalSortUse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter f0 = new PrintWriter(new OutputStreamWriter(System.out));

        int n = toInt(br.readLine());
        LinkedList<Integer>[] list = new LinkedList[1000005];
        // LinkedList<Integer>[] list = new LinkedList[6];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<Integer>();
        }
        Integer inOrder[] = new Integer[list.length];
        Arrays.fill(inOrder, -5);
        //System.out.println(Arrays.toString(inOrder));
        for (int i = 0; i < n; i++) {
            br.readLine();
            int a[] = getIntArray(br.readLine());
            if (inOrder[a[0]] < 0) {
                inOrder[a[0]] = 0;
            }
            for (int j = 1; j < a.length; j++) {
                // System.out.println("a[j] : " + a[j].intValue());
                if (inOrder[a[j]] < 0) {
                    inOrder[a[j]] = 0;
                    //System.out.println("kkk");
                }
                if (!list[a[j - 1]].contains(a[j])) {
                    inOrder[a[j]]++;
                    //System.out.println("nnn");
                }
                //System.out.println(Arrays.toString(inOrder));
            }
            for (int j = 0; j < a.length - 1; j++) {
                if (!list[a[j]].contains(a[j + 1])) {
                    list[a[j]].add(a[j + 1]);
                }
            }
        }
//        System.out.println("inOrder : " + Arrays.toString(inOrder));
//        for (LinkedList<Long> listz : list) {
//            System.out.println(listz.toString());
//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < inOrder.length; i++) {
            if (inOrder[i] == 0) {
                sb.append(i + " ");
                boolean now = false;
                for (int f : list[i]) {
                    inOrder[f]--;
                    if (inOrder[f] == 0 && f < i) {
                        now = true;
                    }
                }
                inOrder[i] = -1;
                if (now) {
                    i = 0;
                }
            }
//            System.out.println(sb.toString());
//            System.out.println("i = " + i);
//            System.out.println("inOrder : " + Arrays.toString(inOrder));
        }
        System.out.println(sb.toString().trim());
    }

    public static Integer toInt(String s) {
        return Integer.parseInt(s.trim());
    }

    public static Long toLong(String s) {
        return Long.parseLong(s.trim());
    }

    public static Double toDouble(String s) {
        return Double.parseDouble(s.trim());
    }

    public static int[] getIntArray(String line) {
        String s[] = line.split(" ");
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static Integer[] getIntegerArray(String line) {
        String s[] = line.split(" ");
        Integer a[] = new Integer[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static Double[] getDoubleArray(String line) {
        String s[] = line.split(" ");
        Double a[] = new Double[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Double.parseDouble(s[i]);
        }
        return a;
    }

    public static Long[] getLongArray(String line) {
        String s[] = line.split(" ");
        Long a[] = new Long[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Long.parseLong(s[i]);
        }
        return a;
    }

    public static Long getMaxFromLongArray(Long a[]) {
        Long max = Long.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static Long getMinFromLongArray(Long a[]) {
        Long min = Long.MAX_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    public static Integer getMaxFromIntegerArray(int a[]) {
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static Integer getMinFromIntegerArray(Integer a[]) {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }
}
