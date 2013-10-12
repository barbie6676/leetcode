/*35. search insert position
binary search
*/

public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length ;
        if (n==0) return 0;
        
        int l = 0;
        int r = n-1;
        while (l<=r){
            int m = (l+r)/2;
            if (A[m]==target) return m;
            if (A[m] < target) l = m+1;
            else r = m-1;
        }
        return l;
    }
