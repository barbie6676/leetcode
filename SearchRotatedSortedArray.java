/*33. Search in Rotated Sorted Array.
algorithm: binary search and recursion.
for a rotated sorted Array (without duplicated elems), divide it by half,
it has to be at least one half is still sorted, do a binary search in that half,
and on the other half call the search rotated recursively.

 This is question can also be implemented with non-recursion, just decide whether target is in the sorted half
and keep on binary search in that half.

81.  Search in Rotated Sorted Array II
algorithm: similar to the iteration of the search in rotated sorted Array I,
when compare the A[l] and A[mid] ,consider 3 situation, <, > and =,
if =, find the next non-equal element
*/


	public int search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
       
        
        return searchAux(A,0,A.length,target);
    }
    
    public int searchAux(int[] A, int start, int end, int target){
          int n = end - start;
        if (n == 0) return -1;
        if (n == 1) return A[start] == target?start:-1;
        
        int mid = (start+end)/2;
        int left = -1;
        if (A[mid-1]>A[start]) {
            left = binarySearch(A,start,mid,target);
        }else {
            left = searchAux(A,start,mid,target);
        }
        
        if (left != -1) return left;
        if (A[mid]<A[end-1]) return binarySearch(A,mid,end,target);
        else return searchAux(A,mid,end, target);
    }
    
    public int binarySearch(int[] A, int start, int end, int target){
           int n = end - start;
        if (n == 0) return -1;
        if (n == 1) return A[start] == target?start:-1;
        
        while (start < end){
            int mid = (start+end)/2;
            if (target == A[mid]) return mid;
            if (target < A[mid]) {
                end= mid;
            } else {
                start = mid +1;
            }
        }
        
        return -1;
        
    }
	
	public int searchIter(int[] A, int target) {
            // Note: The Solution object is instantiated only once and is reused by each test case.
           
            int n = A.length;
            if (n == 0) return -1;
            if (n == 1) return A[0] == target?0:-1;
            
            int l = 0;
            int r = n-1;
            while (l<=r){
                if (l==r) return A[l] == target?l:-1;
                if (l == r-1) return A[l] == target?l:(A[r] == target?r:-1);
                int mid = (l+r)/2;
                if (A[mid] == target) return mid;
                
                if (A[l]<A[mid]){
                    if (target>=A[l]&&target<A[mid]) {
                        r = mid;
                    } else {
                        l = mid+1;
                    }
                    
                    
                } else {
                    if (target>A[mid]&&target<=A[r]){
                        l = mid;
                    } else {
                        r = mid -1;
                    }
                    
                }
            }
        
            return -1;
            
        }
		
		
	public boolean searchII(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return searchAux(A,target)!=-1;
    }
    
    public int searchAux(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         int n = A.length;
            if (n == 0) return -1;
            if (n == 1) return A[0] == target?0:-1;
            
            int l = 0;
            int r = n-1;
            while (l<=r){
                if (l==r) return A[l] == target?l:-1;
                if (l == r-1) return A[l] == target?l:(A[r] == target?r:-1);
                int mid = (l+r)/2;
                if (A[mid] == target) return mid;
                
                if (A[l]<A[mid]){
                    if (target>=A[l]&&target<A[mid]) {
                        r = mid;
                    } else {
                        l = mid+1;
                    }
                    
                    
                } else if (A[l]>A[mid]){
                    if (target>A[mid]&&target<=A[r]){
                        l = mid;
                    } else {
                        r = mid -1;
                    }
                    
                } else {
                    int mmid = mid;
                    while (mmid>l&&A[mmid]==A[l]){
                        mmid --;
                    }
                    if (mmid == l) {
                        l = mid +1;
                    } else {
                        r = mmid;
                    }
                }
                   
            }
        
            return -1;
    }
