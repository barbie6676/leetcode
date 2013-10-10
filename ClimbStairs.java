/*70. climb stairs
algorithm: very typle fibonacci sequence, have the recursive, dp and non-recursive solution
*/

// non recursive, record only curr and last ways of climbing up
public int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) return 0;
        if ( n == 1) return 1;
        
        int last = 1;
        int curr = 1;
        
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr += last;
            last = temp;
        }
        
        return curr;
    }
    
    //DP
    
     public int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) return 0;
        if ( n == 1) return 1;
        
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i =2 ; i <= n; i ++) 
            ways[i] = ways[i-1]+ways[i-2];
            
        return ways[n];
    }
