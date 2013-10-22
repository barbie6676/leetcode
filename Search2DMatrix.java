/*74. search a 2D matrix
algorithm: same as the binary search, O(log(m*n)) or O(log(m)+log(n))...
*/

// here is the correct version of O(m+n) solution
public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int i = 0;
        int j = n-1;
        while (i<m&&j>=0){
            if (matrix[i][j]>target) j--;
            else if (matrix[i][j]<target)i++;
            else return true;
        }
        return false;
    }
    
    
public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = matrix.length;
        if ( m ==0) return false;
        int n = matrix[0].length;
        if (n ==0) return false;
        
        int l = 0; 
        int r = m*n-1;
        while (l<=r) {
            int mid = (l+r)/2;
            
            if (matrix[mid/n][mid%n] == target) return true;
            
            if (matrix[mid/n][mid%n] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        
        return false;
    }
