public double findMedianSortedArrays(int A[], int B[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
       int na = A.length;
        int nb = B.length;
        if (na==0&&nb==0) return -1;
        
       double k1 = fms(A,na,B,nb,(na+nb)/2+1,0,0);
       if ((na+nb)%2==1)  return k1;
       double k2 = fms(A,na,B,nb,(na+nb)/2,0,0);
       return (k1+k2)/2.0;
        
	}
	
	
	    
    public double fms(int A[], int m, int B[], int n, int k,int astart, int bstart){
         
        if (m>n) return fms(B,n,A,m,k,bstart, astart);
         
        if (m==0) return B[bstart+k-1];
        if (k==1) return Math.min(A[astart],B[bstart]);
        int pa = Math.min(k/2,m);
        int pb = k-pa;
        if (A[astart+pa-1]<=B[bstart+pb-1]) return fms(A,m-pa,B,n,k-pa,astart+pa,bstart);
        return fms(A,m,B,n-pb,k-pb,astart,bstart+pb);
    }
