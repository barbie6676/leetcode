/*42. trap rain water

algorithm: record the index of next bank forward and backward* /

public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        if (n<=2) return 0;
        
        int[] afterhigh = new int[n];
        int[] beforehigh = new int[n];
        
        for (int i = 0; i < n ; i++) {
            afterhigh[i] = -1;
            beforehigh[i] = -1;
        }
        
        for (int i = 0; i < n-1; i++) {
            int curr = A[i];
            int j = i+1;
            for(;j<n;j++){
                if (A[j] >= curr) {
                    afterhigh[i] = j;
                    i=j-1;
                    break;
                }
            }
            i=j-1;
        }
        
        for (int i = n-1; i >0; i--) {
            int curr = A[i];
            int j = i-1;
            for(;j>=0;j--){
                if (A[j] >= curr) {
                    beforehigh[i] = j;
                    i=j+1;
                    break;
                }
            }
            i = j+1;
        }
        
        int water = 0;
        for (int i = 0; i<n;i++) {
            if (afterhigh[i]!= -1) {
                int j = i+1;
                for (;j<afterhigh[i];j++){
                    water += (A[i]-A[j]);
                }
                i = j-1;
            }
        }
        
        for (int i = n-1; i>=0;i--) {
            if (beforehigh[i]!= -1) {
                if (afterhigh[beforehigh[i]]>=i) continue;
                int j = i-1;
                for (;j>beforehigh[i];j--){
                    water += (A[i]-A[j]);
                }
                i = j+1;
            }
        }
        
        return water;
    }
