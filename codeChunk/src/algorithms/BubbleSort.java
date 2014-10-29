 

import Algorithms.RandomNumberGenerator;

public class BubbleSort {    
    
    public static void Sort(int A[]){
        
        int i=0,j=0,temp=0;
        
        for(i=0;i<A.length;++i){
            
            for(j=A.length-1;j>i;--j){
                
                if(A[j]<A[j-1]){
                    
                    temp = A[j];
                    A[j] = A[j-1];
                    A[j-1]= temp;
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        int A[] = new RandomNumberGenerator().FillArray(10);
        int i=0;
        for (i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);

        }
        Sort(A);
        System.out.println("");
        for (i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);

        }
    }   

}

 
    


