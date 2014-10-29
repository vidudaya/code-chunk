

/**
 *
 * @author DELL
 */
public class RangeSumInCpp {
    
}
/*
 * #include <stdio.h>
#include <math.h>
#include <iostream>
using namespace std;
 
long long getMid(long long s, long long e) {  return s + (e -s)/2;  }
 
long long getSumUtil(long long *st, long long ss, long long se, long long qs, long long qe, long long index)
{ 
    if (qs <= ss && qe >= se)
        return st[index];
  
    if (se < qs || ss > qe)
        return 0;
 
 
    long long mid = getMid(ss, se);
    return getSumUtil(st, ss, mid, qs, qe, 2*index+1) +
           getSumUtil(st, mid+1, se, qs, qe, 2*index+2);
}
  
void updateValueUtil(long long *st, long long ss, long long se, long long i, long long diff, long long index)
{
   
    if (i < ss || i > se)
        return;
 
    st[index] = st[index] + diff;
    if (se != ss)
    {
        long long mid = getMid(ss, se);
        updateValueUtil(st, ss, mid, i, diff, 2*index + 1);
        updateValueUtil(st, mid+1, se, i, diff, 2*index + 2);
    }
}
 
 
void updateValue(long long arr[], long long *st, long long n, long long i, long long new_val)
{ 
    if (i < 0 || i > n-1)
    {
        printf("Invalid Input");
        return;
    } 
    long long diff = new_val - arr[i]; 
    arr[i] = new_val; 
    updateValueUtil(st, 0, n-1, i, diff, 0);
} long long getSum(long long *st, long long n, long long qs, long long qe)
{ 
    if (qs < 0 || qe > n-1 || qs > qe)
    {
        printf("Invalid Input");
        return -1;
    } 
    return getSumUtil(st, 0, n-1, qs, qe, 0);
} 
long long constructSTUtil(long long arr[], long long ss, long long se, long long *st, long long si)
{
    
    if (ss == se)
    {
        st[si] = arr[ss];
        return arr[ss];
    }
    long long mid = getMid(ss, se);
    st[si] =  constructSTUtil(arr, ss, mid, st, si*2+1) +
              constructSTUtil(arr, mid+1, se, st, si*2+2);
    return st[si];
}
 
 
long long *constructST(long long arr[], long long n)
{ 
    long long x = (long long)(ceil(log2(n)));  
    long long max_size = 2*(long long)pow(2, x) - 1;  
    long long *st = new long long[max_size];
  
    constructSTUtil(arr, 0, n-1, st, 0);
 
   
    return st;
}
 
int main()
{

	long long n,q;
	cin >> n;	
    cin >> q;
	long long arr[n];
	
	for(long long a=0;a<n;++a){
		cin >> arr[a];
	}
	long long *st = constructST(arr, n);
	char c;
	long long t1,t2;
	for(long long b=0;b<q;++b){
		cin >> c;
		if(c=='S'){
		cin >> t1;
		cin >> t2;
		  cout << getSum(st, n, t1, t2);
		  if(b!=q-1){
		  cout << "\n";
		  }
		}else if(c=='G'){
			cin >> t1;
		    cin >> t2;
			updateValue(arr, st, n, t1, arr[t1]+t2);
		} if(c=='T'){
		cin >> t1;
		    cin >> t2;
			updateValue(arr, st, n, t1, arr[t1]-t2);
		}
	}
   
   // long long arr[] = {1, 3, 5, 7, 9, 11};
    //long long n = sizeof(arr)/sizeof(arr[0]);
    //long long *st = constructST(arr, n);
    //printf("Sum of values in given range = %d\n", getSum(st, n, 1, 3));
    // updateValue(arr, st, n, 1, 10);
 
    // printf("Updated sum of values in given range = %d\n",
                                                 // getSum(st, n, 1, 3));
 
    return 0;
}
 */