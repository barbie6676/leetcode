public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        if (n == 0) return -1;
        
        int ret = 0;
        for (int i= 0 ;i < n ; i ++){
            ret ^= A[i];
        }
        return ret^0;
    }
