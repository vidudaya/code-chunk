package algorithms; 

/**
 *
 * @author DELL
 */
public class LongestCommonSubSequence {
    
    public static void findLCSC(int a[]){
        
        int i=0,j=0,max=0;
        
        int dp[] = new int [a.length];
       
       
       
        for(i=0;i<a.length;++i){
            max=0; 
            
            for(j=0;j<i;++j){
               
                if(a[i]>a[j] && max<dp[j]){//stricktly increasing
                    max=dp[j];
                }
                //System.out.println(a[i]+" "+a[j]+" "+max+" "+dp[j]);
            }
            
            dp[i]=max+1;
        }
         
        i=0;
        while(i<a.length){
            System.out.print(dp[i]+" ");
            ++i;
        }
        System.out.println("Maximum out of these numbers will be the LCSC");
        
    }
    
    public static void main(String[] args) {
        
        int a []= {7,16,12,3,4,5};
       
        findLCSC(a);
    }
}
