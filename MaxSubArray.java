/*53. maxinum subarray.
return successive subarray which sum is the largest.
O(n), keep the track of curr sum and global sum

divide and conquer: max subarray must come from three kinds of arrays, in the first half, in the second half,
or cross the mid array.

*/

public int maxSubArray(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int largest = Integer.MIN_VALUE;
        int curr = 0;
        
        for (int i = 0 ; i < A.length; i++) {
            if (A[i] > 0) {
                curr += A[i];
                largest = Math.max(largest,curr);
            } else {
                largest = Math.max(largest,A[i]);
                
                curr = Math.max(curr+A[i],0);
            }
        }
        return largest;
    }
    
    
    public int maxSubArray(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        return maxSubArrayAux(A,0,A.length-1);
    }
    
    public int maxSubArrayAux(int[] A, int l, int r) {
        if (l == r) return A[l];
        
        int m = (l+r)/2;
        
        return Math.max(Math.max(maxSubArrayAux(A,l,m),maxSubArrayAux(A,m+1,r)),
                        maxCrossMidArray(A,l,m,r));
    }
    
    public int maxCrossMidArray(int[]A, int l, int m, int r) {
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = m; i>=l;i-- ){
            sum+=A[i];
            if (sum>leftMax) leftMax = sum;
        }
        
        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = m+1;i<=r;i++){
            sum+=A[i];
            if (sum>rightMax) rightMax = sum;
        }
        return leftMax+rightMax;
    }
