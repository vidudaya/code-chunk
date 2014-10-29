 

import java.io.*;
import java.math.*;
import static java.lang.Math.*;
import java.security.SecureRandom;
import static java.util.Arrays.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.Regexp;

/**
 *
 * @author DELL
 */
public class BinarySearchArray {

    public static void main(String[] args) {

        int a[] = {213, 23, 12, 54, 6, 23, 87, 12, 98, 970, 21, 33, 42, 65, 7, 573, 35, 53, 17};

        System.out.println(Arrays.toString(a));

        Arrays.sort(a);//nlog(n)
        sort(a);
        System.out.println(Arrays.toString(a));
        
        
        int pos23 = binarySearch(a, 23);
        System.out.println("pos23 = "+pos23);
    }
}
