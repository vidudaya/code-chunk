 

import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * @author DELL
 */
public class TreeSetHandle {

    public static void main(String[] args) {

        TreeSet<Integer> tst = new TreeSet<Integer>();

        tst.add(213);
        tst.add(545);
        tst.add(532);
        tst.add(232);
        tst.add(136);
        tst.add(13);

        Integer a[] = tst.toArray(new Integer[tst.size()]);
        System.out.println(Arrays.toString(a));

        int n = tst.pollFirst();
        System.out.println("n = "+n);
        a = tst.toArray(new Integer[tst.size()]);
        System.out.println(Arrays.toString(a));

        n = tst.first();
        System.out.println("n = " + n);
        a = tst.toArray(new Integer[tst.size()]);
        System.out.println(Arrays.toString(a));
    }
}
