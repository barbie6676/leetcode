/*51. N queens

algorithm: forward and backforth.
record the positions of all the previous queens,
if (forward) mean that your are looking for a position for child queen, iterate from position 0-n,
  if found, (all queens placed, add to result then back,) otherwise, go to the next queen, 
  if not found, backward.
if (backward) mean that your are looking for a position for brother queesn, so erase the last position, start from next position.
  if found, (all queens placed, add to result then back) otherwise, go forward for next child queen,
  if not found, continue backward.
*/

public ArrayList<String[]> solveNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //hui su fa
        
        ArrayList<String[]> ret = new ArrayList<String[]>();
        if (n == 0) return ret;
        
        if (n == 1) {
            String[] board = new String[1];
            board[0] = "Q";
            ret.add(board);
            return ret;
        }
        
        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            String dot = "";
            for (int j = 0; j < n ; j++) {
                dot += '.';
            }
            board[i] = dot;
        }
        
        int[] currPos = new int[n];
        
        int k = 0;
        boolean forward = true;
        while (k>=0) {
            if (forward) {
                StringBuilder row = new StringBuilder(board[k]);
                row.setCharAt(currPos[k],'.');
                int i = 0;
                boolean can = false;
                for (; i < n ; i++) {
                    can = true;
                    for (int j = 0; j < k&&can;j++){
                        if (i==currPos[j]||k-j == Math.abs(i-currPos[j])) can = false;
                    }
                    if (can) {
                        row.setCharAt(i,'Q');
                        board[k] = row.toString();
                        currPos[k] = i;
                        break;
                    }
                }
                
                if (can) { //find a position for current kth queen
                    k++;
                    if (k==n) {
                        String[] copy = board.clone();
                        ret.add(copy);
                        forward = !forward;
                        k--;
                    }
                } else {
                    forward = !forward;
                    k--;
                }
                
            } else {//backward;try from the currentPos of this queen.
                StringBuilder row = new StringBuilder(board[k]);
                int i = currPos[k];
                row.setCharAt(i,'.');
                boolean can = false;
                for (i = i+1; i < n ; i++) {
                    can = true;
                    for (int j = 0; j < k&&can;j++){
                        if (i==currPos[j]||k-j == Math.abs(i-currPos[j])) can = false;
                    }
                    if (can) {
                        row.setCharAt(i,'Q');
                        board[k] = row.toString();
                        currPos[k] = i;
                        break;
                    }
                }
                
                if (can) { //find a position for current kth queen
                    k++;
                    forward = !forward;
                    if (k==n) {
                        String[] copy = board.clone();
                        ret.add(copy);
                        forward = !forward;
                        k--;
                    }
                } else {
                    k--;
                }
                
            }
        }
        
        return ret;
    }
