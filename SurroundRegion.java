public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        
        if (m<3||n<3) return;
        
        for (int i = 0; i < m; i++) {
        	mark(board, i,0);
        	mark(board,i,n-1);
        }
        for (int j = 0; j < n; j++) {
        	mark(board, 0,j);
        	mark(board,m-1,j);
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n ; j++) {
        		if (board[i][j] == 'O'){
        			board[i][j] = 'X';
        		} else if (board[i][j] == 'M'){
        			board[i][j] = 'O';
        		}
        	}
        	
        }
    }
	
	public void mark (char[][] board, int x, int y) {
		if (x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]!='O') return;
		board[x][y] = 'M';
		mark(board,x-1,y);
		mark(board,x+1,y);
		mark(board,x,y-1);
		mark(board,x,y+1);
        
    }
