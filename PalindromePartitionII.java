/*132 palindrome partitioning II
 algorithm: 
	1. recursion, find the palindroms substring, add 1 to the mincut of the rest of the string, O(n^2) of course time limit exceed

	2. DP
 data structure:
	For DP, use a n array to record the mincut from here to the end of the string, start from the back i, once find a palindrome i-j, mincut[i] = 1+mincut[j+1]
  
 */


	
	public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int mincut = Integer.MAX_VALUE;
		
		if (isPalindrom(s)) return 0;
	
		for (int i = 1; i < s.length();i++) {
			if (isPalindrom(s.substring(0,i))) {
				int cut = 1 + minCut(s.substring(i));
				if (cut < mincut) mincut = cut;
			}
		}
        
        return mincut;
    }
	public boolean isPalindrom(String s) {
		if (s.length()<=1) return true;
		for (int i = 0; i < s.length()/2;i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		}
		
		return true;
	}
	
	//dp approach
	
	
	public int minCutDP(String s) {
		
		
		 int len = s.length();  
		 int[] D = new int[len];  
		 boolean[][] P = new boolean[len][len];  
		 //the worst case is cutting by each char  
		 //D[i] mean, substring start at the index of i to the end,
		 // how many cuts it need to become all palindrome
		 //initially, the left most index need less cut, and the right most needs most cut.
		 for(int i = 0; i < len; i++)   {
			 D[i] = len-1-i;  
		 }
		     
		 // P[i][j] means substring start at i and end at j is a palindrome or not.     
		 for(int i = 0; i < len; i++)  {
			  for(int j = 0; j < len; j++)  {
				  P[i][j] = false;  
			  }
		 }
	         
		 //shift from right to left, update P matrix and then update D.           
	     for(int i = len-2; i >= 0; i--){  
             for(int j = i; j < len; j++){  
             	// if i-j is a palindrome,
                 if(s.charAt(i) == s.charAt(j) && (j-i<2 || P[i+1][j-1])){  
	                 P[i][j] = true;  
	                 // the min cut start from i == the min cut after j plus the one cut between j and j+1
	                 if (j<len -1) D[i] = Math.min(D[i],D[j+1]+1);  
	                 else D[i] = 0;
                  }  
           }  
        }  
        return D[0];  

	}
