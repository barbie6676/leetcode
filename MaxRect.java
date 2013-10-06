/*85. Maximal Rectangle 
algorithm: find the wide width, then find the most continuous height, O(n^3)
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;
        if (n==0) return 0;
        
        int[][] num = new int[m][n];
        
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n;j++) {
                if (j ==0) {
                    num[i][j] = matrix[i][j]=='0'?0:1;
                } else {
                    num[i][j] = matrix[i][j]=='0'?0:(num[i][j-1]+1);
                }
            }
        }
        
        int maxArea = Integer.MIN_VALUE;
        for (int j = 0; j<n;j++){
            int[] downsmall = new int[m];
            int[] upsmall = new int[m];
            downsmall[m-1]= m;
             int k = m-2;
            while (k>=0) {
                if (num[k][j]<=num[k+1][j]) {
                    int d = k+1;
                    while (downsmall[d]<m&&num[downsmall[d]][j]>=num[k][j]) d = downsmall[d];
                    downsmall[k]= downsmall[d];
                }
                else downsmall[k]=k+1;
                k--;
            }
            
            upsmall[0]=-1;
            k = 1;
            while (k<m) {
                if (num[k][j]<=num[k-1][j]) {
                    int d = k-1;
                    while (upsmall[d]>=0&&num[upsmall[d]][j]>=num[k][j]) d = upsmall[d];
                    upsmall[k]= upsmall[d];
                }
                else upsmall[k]=k-1;
                k++;
            }
           
            
            for (int i = 0; i <m ; i++){
                maxArea = Math.max(maxArea,(downsmall[i]-upsmall[i]-1)*num[i][j]);
            }
        }
        
        return maxArea;
    }
}
