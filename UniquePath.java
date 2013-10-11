/*62. unique path
algorithm: recursion: time limit exceed
or C(m-1,m+n-2), figure out O(m+n) way to calculate the value

63. unique paths II
algorithm: recursion

*/

//recursion
public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (m==0 || n == 0) return 0;
        if (m ==1 || n ==1) return 1;
        
        int[] paths = new int[1];
        //int[] currPos = new int[2];
        
        uniquePaths(m,n,0,0,paths);
        
        return paths[0];
    }
    
    public void uniquePaths(int m, int n , int x, int y, int[] paths) {
        if (x == m-1 && y == n-1) {
            paths[0]++;
            return;
        }
        
        if (x>= m || y >= n) return;
        
        uniquePaths(m,n,x+1,y,paths);
        uniquePaths(m,n,x,y+1,paths);
    }
    
    
    //recursion
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int m = obstacleGrid.length;
        if (m==0 ) return 0;
        int n = obstacleGrid[0].length;
        if (n==0) return 0;
        if (m ==1 || n ==1) return 1;
        
        int[] paths = new int[1];
        //int[] currPos = new int[2];
        
        uniquePaths(obstacleGrid,0,0,paths);
        
        return paths[0];
    }
    
    public void uniquePathsAux(int[][] grid , int x, int y, int[] paths) {
        if (x == grid.length-1 && y == grid[0].length-1) {
            paths[0]++;
            return;
        }
        
        if (x>= grid.length || y >= grid[0].length || grid[x][y] == 1) return;
        
        uniquePathsAux(grid,x+1,y,paths);
        uniquePathsAux(grid,x,y+1,paths);
    
    }
