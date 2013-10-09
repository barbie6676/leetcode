/*79. Word search
algorithm: DFS
*/
public boolean exist(char[][] board, String word) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int m = board.length;
        if (m == 0) return word.isEmpty();
        int n = board[0].length;
        if (n == 0) return word.isEmpty();
        
        if (word.length()>m*n) return false;
        
        int[][] direction = new int[4][2];
        
        direction[0][0] = -1;
        direction[1][0] = 1;
        direction[2][1] = -1;
        direction[3][1] = 1;
        
        boolean[][] used = new boolean[m][n];
        
        boolean found = false;
        
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n ; j++) {
                
                found = existAux(board,direction, used, word, i,j);
                
                if (found) return true;
            }
        }
        
        return found;
    }
    
    public boolean existAux(char[][] board,int[][] direction,boolean[][] used, String word,int x, int y){
        if (word.isEmpty()) return true;
        
        if (x<0||x>=board.length||y<0||y>=board[0].length||used[x][y]) return false;
        
        if (board[x][y]!=word.charAt(0)) return false;
        
        boolean found = false;
        used[x][y] = true;
        for (int i = 0; i<4;i++){
            found = existAux(board,direction,used,word.substring(1),x+direction[i][0],y+direction[i][1]);
           
            if (found)return true;
            
        }
        used[x][y] = false;
        return false;
        
    }
