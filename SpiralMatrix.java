/*
54. spiral matrix 

four boundaries, four directions.

59. spiral matrix II
algorithm:  marker at top line, bottom line, left col and right col.
iterate four directions accordingly

*/
public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        
        int m = matrix.length;
        if (m == 0) return ret;
        int n = matrix[0].length;
        if (n == 0) return ret;
        
        int top = 0;
        int right = n-1;
        int bottom = m-1;
        int left = 0;
        
        int it = left;
        int direction = 0;
        
        while (left <= right && top <= bottom) {
            if (direction == 0) {
                for (it = left; it <= right ; it++){
                    ret.add(matrix[top][it]);
                }
                top++;
                direction++;
            } else if (direction == 1) {
                for (it = top;it<=bottom;it++){
                    ret.add(matrix[it][right]);
                }
                right--;
                direction++;
            } else if (direction == 2) {
                for (it = right ; it>=left;it--){
                    ret.add(matrix[bottom][it]);
                }
                bottom--;
                direction++;
            } else {
                for (it = bottom ; it >= top;it--){
                    ret.add(matrix[it][left]);
                }
                direction = 0;
                left++;
            }
        }
        
        return ret;
}


public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
       int[][] matrix = new int[n][n];
        int num = 1;
        
        int top = 0;
        int right = n-1;
        int bottom = n-1;
        int left = 0;
        
        int it = left;
        int direction = 0;
        
        while (left <= right && top <= bottom) {
            if (direction == 0) {
                for (it = left; it <= right ; it++){
                    matrix[top][it] = num++;
                }
                top++;
                direction++;
            } else if (direction == 1) {
                for (it = top;it<=bottom;it++){
                    matrix[it][right]= num++;
                }
                right--;
                direction++;
            } else if (direction == 2) {
                for (it = right ; it>=left;it--){
                    matrix[bottom][it]= num++;
                }
                bottom--;
                direction++;
            } else {
                for (it = bottom ; it >= top;it--){
                    matrix[it][left]= num++;
                }
                direction = 0;
                left++;
            }
        }
        
        return matrix;
    }
