 

import java.util.Enumeration;
import java.util.Stack;

/**
 *
 * @author DELL
 */
public class Stack_Codes {

    public static void main(String[] args) {

        Stack st = new Stack();

        st.push("1");
        st.push("2");
        st.push("3");
        st.push("4");
        st.push("5");

        String s = st.toString();
        // s = s.replaceAll("[^a-z/]", "");
        System.out.println(s);

        st.pop();
        st.pop();

        s = st.toString();
        // s = s.replaceAll("[^a-z/]", "");
        System.out.println(s);
        
        st.add(2, "8");
        /*
         * Inserts the specified element at the specified position in this Vector. Shifts 
         * the element currently at that position (if any) 
         * and any subsequent elements to the right (adds one to their indices).
         */
        s = st.toString();
        // s = s.replaceAll("[^a-z/]", "");
        System.out.println(s);
        
        Enumeration e ;
        for(e=st.elements();e.hasMoreElements();){
        System.out.println(e.nextElement());
        }
        
        
}}
