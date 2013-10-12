/*41. first missing positive
algorithm: using sign as the marker whether a pos num appears.

num out of A.length range and neg num are out of considerations, because missing number can only be (1,A.length+1) range,

flip the sign of A[A[i]-1] to negative as marker, meaning pos num of A[i] has appeared.

sweep the array again, the first index with pos value is the first missing num -1;
if at the end of array, meaning 1-n are already there ,return n+1
*/


public int firstMissingPositive(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        if (n == 0) return 1;
        
        for (int i = 0; i < n ; i++) {
            if (A[i]<=0) A[i] = n+2;
        }
        
        for (int i = 0; i < n ; i++) {
            int idx = Math.abs(A[i]);
        
            if (idx<=n&&A[idx-1]>0) A[idx-1] = 0-A[idx-1];
        }
       
        for ( int i = 0; i < n; i++) {
            if (A[i]>0) return i+1;
        }
         return n+1;
    }
