/*115.
algorithm: DP, substring of T start with j , substring of S start with i, if T.charAt(j)== S.charAt(i) , distinct subsequence number will be that of T(start with j) in S(start with i+1) plus
T(start with j+1) in S(start with i+1), otherwise, it only equals T(start with j) in S(start with i+1)

look at the 2D array you can understand, fill in the table from right lower corner , 
each cell value is calculated based on the right cell and righ low cell, left upper corner[0][0] is the result
 S(i)
T(j) 0 1 2 3
   0        |0 
   1        |0
   2________|0
     1 1 1 1 1 
*/
public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int s = S.length();
        int t = T.length();
        
        if (t>s) return 0;
        if (t == s) return S.equals(T)?1:0;
        if (t==0) return 1;
        
        int[] count = new int[t+1];
        count[t]=1;
        
        for(int i = s-1; i>=0;i--){
            
            for (int j = 0; j<t;j++) {
                
                count[j] += (T.charAt(j)==S.charAt(i)?count[j+1]:0);
            }
        }
        
        return count[0];
    }
