/*72.Edit distance
Thanks to GXJ
algorithm: it's a very very typical DP problem, editing can be mapped to movement in matrix:
no editing: move right down without +1
replace:    move right down +1
insert:     move right +1
delete:     move down +1

at each step, the minimal distance can only be the minimal distance of last step (+1 or not),
the value at the right low corner is the result.
*/


public int minDistance(String word1, String word2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = word1.length();
        int n = word2.length();
        
        int[][] distance = new int[m+1][n+1];
        
        for (int i = 0; i <= m ; i ++) {
            distance[i][0] = i; //first column
        }
        
         for (int j = 1; j <= n ; j ++) {
            distance[0][j] = j;
        }
        
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++){
                int leftup = word1.charAt(i-1)==word2.charAt(j-1)?distance[i-1][j-1]:(distance[i-1][j-1]+1);
                distance[i][j] = Math.min(leftup,Math.min(distance[i-1][j],distance[i][j-1])+1);
            }
        }
        
        return distance[m][n];
    }
