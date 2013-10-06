/*97. Interleaving String 
algorithm: DP: two functions: f(a,b) true if the first a of s1 and first b of s2 form interleave of first (a+b) of s3
                              g(a,b,1) true if f(a,b)= true and the last char (char at a+b) comes from s1
							  g(a,b,2) true if the last char came from s2.
							  
							  so f(a,b) = g(a,b,1) or g(a,b,2)
							  g(a,b,1) = s1.charAt(a)==s3.charAt(a+b)?f(a-1,b):false;
							  g(a,b,2) = s2.charAt(b)==s3.charAt(a+b)?f(a,b-1):false;
							  
							  it's so cofusing.
							  
							  the order to traversal the matrix, if from left upper corner, to right lower corner.
							  or top row, leftmost col first.
							  then row by row.
*/

 public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n1 = s1.length();
		int n2 = s2.length();
		 if (s3.length() < n1|| s3.length() < n2) return false;
		 if (s3.length() != (n1 + n2))return false;
		 if (n1 ==0) return s2.equals(s3);
		 if (n2 ==0) return s1.equals(s3);
	 
	 boolean[][] f = new boolean[n1+1][n2+1];
	 boolean[][][] g = new boolean[n1+1][n2+1][2];
	 //boolean[][] g2 = new boolean[n1+1][n2+1];
	 
	 f[0][0] = true;
	 for (int k = 0; k<=(n2>n1?n1:n2);k++){
		 for (int j = 0; j< n2;j++){ // sweep rows, to the end of s2
			 
			  g[k][j+1][1] = s2.charAt(j)==s3.charAt(j+k)?f[k][j]:false;
			  if (k==0)g[k][j+1][0] = false;
			  else g[k][j+1][0] = s1.charAt(k-1)==s3.charAt(j+k)?f[k-1][j+1]:false;
			  
			  f[k][j+1] = g[k][j+1][0]||g[k][j+1][1];
			 
		 }
		
		 for (int i = 0 ; i<n1;i++){
			 g[i+1][k][0] = s1.charAt(i)==s3.charAt(i+k)?f[i][k]:false;
			 if (k==0)g[i+1][k][1] = false; 
			 else g[i+1][k][1] = s2.charAt(k-1)==s3.charAt(i+k)?f[i+1][k-1]:false;; 
			 
			 f[i+1][k] = g[i+1][k][0]||g[i+1][k][1];
		 }
		 
		
	 }
	
	 
     return f[n1][n2];
    }
