 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SortArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        Collections.sort(list);

        list.add(341);
        list.add(564);
        list.add(244);
        list.add(123);

        Integer a[] = list.toArray(new Integer[list.size()]);
        
        System.out.println(Arrays.toString(a));
    }
}
