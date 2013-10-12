/*37. sudoku solver
algorithm: backforth, very similar to NQueen. O(n^3), n = 9

36. valid sudoku
similar to above*/

public class Point{
        int x;
        int y;
        public Point(int a, int b){
            x = a;
            y = b;
        }
    }
    
    public boolean isValidSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
  
        
        boolean[][] rowused = new boolean[9][9]; 
        boolean[][] colused = new boolean[9][9]; 
        boolean[][] regionused = new boolean[9][9]; 
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                   
                    int d = board[i][j] - '1';
                    if (rowused[i][d] == true) return false;
                    rowused[i][d] = true;
                    if (colused[j][d] == true) return false;
                    colused[j][d] = true;
                    if (regionused[region(i,j)][d] == true) return false;
                    regionused[region(i,j)][d] = true;
                }
            }
        }
        
        return true;
    }
    
    
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Point> tofill = new ArrayList<Point>();
        //ArrayList<ArrayList<Integer>> available = new ArrayList<ArrayList<Integer>>();
        
        boolean[][] rowused = new boolean[9][9]; 
        boolean[][] colused = new boolean[9][9]; 
        boolean[][] regionused = new boolean[9][9]; 
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    tofill.add(new Point(i,j));
                } else {
                    int d = board[i][j] - '1';
                    rowused[i][d] = true;
                    colused[j][d] = true;
                    regionused[region(i,j)][d] = true;
                }
            }
        }
        
        
        int fill = 0;
        int[] currSelection = new int[tofill.size()];
        
        boolean forward = true;
        while (fill>=0) {
            if (forward) {
                Point p = tofill.get(fill);
                board[p.x][p.y] = '.';
                int j = 0;
                for (; j<9;j++){
                    if (rowused[p.x][j]||colused[p.y][j]||regionused[region(p.x,p.y)][j])
                        continue;
                    break;
                }
                
                if (j <9) {
                    currSelection[fill] = j;
                    board[p.x][p.y] = (char)(j+'1');
                    fill++;
                    rowused[p.x][j] = true;
                    colused[p.y][j] = true;
                    regionused[region(p.x,p.y)][j] = true;
                    if (fill == tofill.size()) return;
                } else {
                    currSelection[fill] = -1;
                    fill --;
                    forward = !forward;
                }
            } else {
                Point p = tofill.get(fill);
                board[p.x][p.y] = '.';
                int curr = currSelection[fill];
                
                if (curr != -1){
                    rowused[p.x][curr] = false;
                    colused[p.y][curr] = false;
                    regionused[region(p.x,p.y)][curr] = false;
                }
                int j = curr+1;   
                for (; j<9;j++){
                    if (rowused[p.x][j]||colused[p.y][j]||regionused[region(p.x,p.y)][j])
                        continue;
                    break;
                }
                
                if (j <9) {
                    currSelection[fill] = j;
                    board[p.x][p.y] = (char)(j+'1');
                    fill++;
                    rowused[p.x][j] = true;
                    colused[p.y][j] = true;
                    regionused[region(p.x,p.y)][j] = true;
                    if (fill == tofill.size()) return;
                    forward = !forward;
                } else {
                    currSelection[fill] = -1;
                    fill --;
                }
            }
        }
    }
    
    public int region(int x, int y) {
        return (x/3)*3+(y/3);
    }
