/*73. Set Matrix Zeroes 
algorithm: use the first row and first col as the markers.
*/


 public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = matrix.length;
        if (m ==0) return;
        int n = matrix[0].length;
        if (n ==0) return;
        
        boolean firstRow = false;
        boolean firstCol = false;
        
        for (int j = 0; j < n;j++){
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        
        for (int i = 0; i < m;i++){
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        
        for (int i = 0; i < m ; i ++){
            for (int j = 0; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < n;j++){
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m;i++){
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstRow) {
            for (int j = 0; j < n;j++){
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < m;i++){
                matrix[i][0] = 0;
            }
        }
        
    }
