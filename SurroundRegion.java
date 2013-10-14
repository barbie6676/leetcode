/*
recursion: stack overflow for big matrix,
non-recusion: BFS, start from the O' on the four edges, use a queue to implement BFS.
*/


public class Point{
        int x;
        int y;
        public Point(int a, int b){
            x = a;
            y = b;
        }
    }
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        
        if (m<3||n<3) return;
        
        boolean[][] touched = new boolean[m][n];
        int[][] steps = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for (int i = 0; i < m; i++) {
        	mark(board,touched,steps,i,0);
        	mark(board,touched,steps,i,n-1);
        }
        for (int j = 1; j < n-1; j++) {
        	mark(board,touched,steps, 0,j);
        	mark(board,touched,steps,m-1,j);
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
	
	public void mark (char[][] board, boolean[][] touched,int[][] steps, int a, int b) {
		if (board[a][b] == 'O'&&!touched[a][b]){
    	    touched[a][b] = true;
    	    board[a][b] = 'M';
    	    Queue<Point> q = new LinkedList<Point>();
    	    q.add(new Point(a,b));
    	    while(!q.isEmpty()) {
    	        Point curr = q.poll();
    	        for (int k = 0; k < 4; k++) {
    	            int x = curr.x + steps[k][0];
    	            int y = curr.y + steps[k][1];
    	            if (inbound(x,y,board)){
    	                if (board[x][y] == 'O'&&!touched[x][y]) {
    	                    touched[x][y] = true;
    	                    board[x][y] = 'M';
    	                    q.add(new Point(x,y));
    	                }
    	            }
    	        }
    	    }
    	}
        
    }
    
    public boolean inbound(int x, int y, char[][] board) {
        return x>=0&&x<board.length&&y>=0&&y<board[0].length;
    }
    
    
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
		if (!inbound(x,y,board)||board[x][y]!='O') return;
		board[x][y] = 'M';
		mark(board,x-1,y);
		mark(board,x+1,y);
		mark(board,x,y-1);
		mark(board,x,y+1);
        
    }
