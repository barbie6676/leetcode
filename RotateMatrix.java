/*48. rotate image*/

public void rotate(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = matrix.length;
        if (n == 0) return;
      
        
        for (int i = 0; i < n/2; i ++) {
            for (int j = i ; j < n-1-i ; j++) {
                int top = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = top;
            }
        }
    }
