/*91. Decode Ways
algorithm: can be either recursion, like restore IP, put the string into two parts, used and left, when left is empty,
add 1 to the totoal results.

since only num of ways is need, we can also use DP, the total ways at current idx only dependent on the the ways at index +1 and index +2,
prepare a int[n] ,fill in from back to front.
 */


public int numDecodings(String s) {
        int n = s.length();
		if (n == 0) return 0;
		if (n ==1) return s.charAt(0)=='0'?0:1;
	
		
		int[] ways = new int[n+1];
		ways[n] = 1;
		ways[n-1] = s.charAt(n-1)=='0'?0:1;
		int idx = n-2;
		while (idx >=0) {
			int n1 = s.charAt(idx)=='0'?0:ways[idx+1];
			int n2 = validCode(s.substring(idx,idx+2))?ways[idx+2]:0;
			ways[idx] = n1+n2;			
			idx --;
		}
		
		return ways[0];
    }
    
    public boolean validCode(String s) {
        if (s.length() ==0 || s.length()>2) return false;
        if (s.charAt(0) == '0') return false;
        
        int n = s.charAt(0)-'0';
        for (int i = 1; i < s.length(); i++) n = n*10+ s.charAt(i)-'0';
        
        return n>=1&&n<=26;
    }
	
	//recursion
public int numDecodings(String s) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int[] ret = new int[1];
	        numDecodingsAux(ret,"",s);
	        
	        return ret[0];
	    }
	    
	    public void numDecodingsAux(int[] ret, String used, String left) {
	        if (left.isEmpty()) {
	            ret[0]++;
	            return;
	        }
	        
	        for (int i = 0; i<left.length();i++){
	            String curr = left.substring(0,i+1);
	            if (validCode(curr)){
	                   numDecodingsAux(ret,used+curr,left.substring(i+1));
	            } else {
	                continue;
	            }
	        }
	    }
