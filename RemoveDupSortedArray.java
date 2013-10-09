/*26. Remove Duplicates from Sorted Array 
algorithm: two pointers, one iterate the full array, the other keeps at the end of the list with only unique list.

80.  Remove Duplicates from Sorted Array II
algorithm: add a counter to count the replicates, if overshoot 2, tail move two steps.
*/


public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        if (n<=1) return n;
        
        int p = 1;
        int tail = 0;
        
        while (p<A.length){
            while (p<A.length&&A[p]==A[tail]){
                p++;
                n--;
            }
            if (p<A.length){
                A[++tail] = A[p++];
            }
        }
        
        return n;
    }
	
 public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        
        if (n<=2) return n;
        
        int tail = 0;
        int p =1;
        int count = 1;
        
        while (p < A.length){
            while(p<A.length&&A[p] == A[tail]){
                count++;
                p++;
            }
            if (p<A.length){
                if (count >=2) {
                    A[tail+1]=A[tail];
                    A[tail+2]=A[p++];
                    tail += 2;
                    n -= (count-2);
                   
                 }else{
                    A[++tail]=A[p++];
                    
                }
                
            } else if (count >=2){
                 A[tail+1]=A[tail];
                   
                 n -= (count-2);
                 break;
            }
            count = 1;
            
        }
        
        return n;
    }
