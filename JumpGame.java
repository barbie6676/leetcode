/*55. jump game
algorithm: iterate from back, always keeps the front most element which can reach the end.

data structure: stack
*/

 public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        if (n==0) return false;
        if (n ==1) return true;
        if (n ==2) return A[0]!=0;
    
        Stack<Integer> s = new Stack<Integer>();
        for (int i = n -2; i>=0; i--) {
            if (A[i]!=0){
                if(s.isEmpty()){
                    if(A[i]+i>=n-1) {
                        s.push(i);
                
                    }
                } else {
                    if (A[i]+i>= s.peek()){
                        s.pop();
                        s.push(i);
                    }
                }
            }
        }
        if (s.isEmpty()) return false;
        return s.peek() == 0;
    }
