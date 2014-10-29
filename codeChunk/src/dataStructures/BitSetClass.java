 

import java.util.BitSet;

/**
 *
 * @author DELL
 */
public class BitSetClass {

    public static void main(String[] args) {

        BitSet bt = new BitSet();
        bt.set(5);
        bt.set(2);
        bt.set(7);
        bt.set(1);
        System.out.println(bt.cardinality());
        System.out.println(bt.toString());
        System.out.println(bt.nextSetBit(2));
        System.out.println(bt.nextClearBit(1));
        System.out.println(bt.nextSetBit(0));
        System.out.println(bt);

    }
}
