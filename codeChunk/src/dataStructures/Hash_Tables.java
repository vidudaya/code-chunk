 

import java.util.Arrays;
import java.util.Hashtable;

/**
 *
 * @author DELL
 */
public class Hash_Tables {

    public static void main(String[] args) {

        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

        ht.put(1, 1);
        ht.put(34, 34);
        ht.put(14, 14);
        ht.put(4, 4);
        ht.put(74, 74);

        Integer a[] = ht.values().toArray(new Integer[ht.size()]);
        System.out.println(Arrays.toString(a));
        
       
    }
}
