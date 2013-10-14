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
    
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        if(n == 0){
            return -1;
        }
         
         int[] counts = new int[32];
         int result = 0;
         for(int i = 0; i < 32; i++){
            for(int j = 0; j < n; j++){
                 if(((A[j] >> i) & 1) == 1){
                     counts[i] = (counts[i] + 1) % 3;
                 }
             }
             result |= (counts[i] << i);
         }
         
        return result;
    }
