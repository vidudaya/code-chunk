 
/**
 *
 * @author DELL
 */
public class BinaryToDecimal {
     public static int dec(String text) {
        
        int l = 0;
        for (byte b : text.getBytes()) {
            l = (l << 1) | (b & 1);
        }
       
        return l;
    }
     
     public static void main(String[] args) {
         System.out.println(dec("1000"));
    }
}
