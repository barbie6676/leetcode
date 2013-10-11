/*59. spiral matrix II
algorithm:  marker at top line, bottom line, left col and right col.
iterate four directions accordingly

*/

public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[][] matrix = new int[n][n];
        
        int top = 0;
        int right = n;
        int bottom = n;
        int left = 0;
        
        int it = 0;
        int num = 1;
        int direction = 0;
        
        while(right > left && bottom > top) {
            if (direction == 0) { //left -> right
                for (it = left; it < right; it++){
                    matrix[top][it] = num++;
                }
                right--;
                direction ++;
            } else if(direction == 1) {//top -> down
                for (it = top+1;it<bottom;it++){
                    matrix[it][right] = num++;
                }
                bottom--;
                direction ++;
                
            } else if (direction == 2) {//right -> left
                for(it = right-1; it >= left; it--){
                    matrix[bottom][it] = num++;
                }
                direction++;
                
            } else { // bottom -> up
                for (it = bottom -1; it > top;it--){
                    matrix[it][left] = num++;
                }
                direction = 0;
                left++;
                top++;
            }
        }
        
        return matrix;
    }
