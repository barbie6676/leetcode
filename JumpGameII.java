/*45. jump game II
algorithm: similar thinking as the jump game I, DP, record the minimal steps needed from current position.
but only keep the front most index of the same steps.
data  structure: stack, if one position has same steps but behind ,just pop the position.
*/


public int jump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         int n = A.length;
        if (n==0) return 0;
        if (n ==1) return 0;
        if (n ==2) return A[0]!=0?1:Integer.MAX_VALUE;
        
       
        Stack<Integer> s = new Stack<Integer>();
		int[] steps = new int[n-1];
		
        for (int i = n -2; i>=0; i--) {
            if (A[i]+i>=n-1){
				steps[i] = 1;
				while (!s.isEmpty()) {
				    s.pop();
				}
			    s.push(i);	
            } else if (A[i] != 0) {
                int idx = -1;
				while(!s.isEmpty()&&A[i]+i>=s.peek()){
				    idx = s.pop();
				}
				if (idx!=-1){
				    s.push(idx);
				    s.push(i);
				    steps[i] = steps[idx]+1;
				} else {
				    steps[i] = Integer.MAX_VALUE;
				}
			} else {
                   steps[i]= Integer.MAX_VALUE;
            }
            
        }
       
        return steps[0];
		
    }
