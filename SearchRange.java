/*34. search range;
apply binary search to both ends*/

public int[] searchRange(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        
        if (A.length == 0) return ret;
        int l = 0; 
        int r = A.length -1;
        while (l<=r){
            int m = (l+r)/2;
            if (A[m] == target) {
                ret[0] = m;
                ret[1] = m;
                break;
            }
            if (A[m]<target) l = m+1;
            else r = m-1;
        }
        
        if (r<l) return ret;
        
        while (ret[1]<=r){
            int m = (ret[1]+r)/2;
            if (A[m] == target) ret[1] = m+1;
            else r = m-1;
        }
        ret[1] = r;
        
         while (ret[0]>=l){
            int m = (ret[0]+l)/2;
            if (A[m] == target) ret[0]= m-1;
            else l = m+1;
        }
        ret[0] = l;
        
        return ret;
    }
