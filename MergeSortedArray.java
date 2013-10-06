/*88. Merge Sorted Array.
algorithm: move two pointers from back to front*/

public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int a = m-1;
        int b = n-1;
        int k = m+n-1;
        
        while (a>=0&&b>=0) {
            if (A[a]>B[b]) A[k--] = A[a--];
            else A[k--] = B[b--];
        }
        
        if (a<0) {
            while(b>=0){
                A[k--] = B[b--];
            }
        }
    }
