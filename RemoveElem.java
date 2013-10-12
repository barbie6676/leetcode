/*27 remove element* /

public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        
        if (n == 0) return 0;
        
        int instance = 0;
        
        for (int i = 0 ; i < n ; i++) {
            if (A[i] == elem) {
                instance ++;
            } else {
                A[i-instance] = A[i];
            }
        }
        
        return n - instance;
    }
