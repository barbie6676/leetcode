 /*128. longest Longest Consecutive Sequence
  algorithm:for each element, store the currlen containing itself, its leftend and right end,
  for each new coming element, check whether the number adjencent to it already exsits, if so, connect the len, update the end index for both new ends.
  Data structure: Hashmap
*/


public int longestConsecutive(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int l = num.length;
	        if (l<= 1) return l;
	        if (l == 2) return Math.abs(num[0]-num[1])==1?2:1;
	        
	        HashMap<Integer, Integer> currLen = new HashMap<Integer, Integer>();
	        HashMap<Integer, Integer> leftEnd = new HashMap<Integer, Integer>();
	        HashMap<Integer, Integer> rightEnd = new HashMap<Integer, Integer>();
	        
	        int longest = 0;
	        for (int i = 0; i<l; i++) {
	            int n = num[i];
	            if (!currLen.containsKey(n)) {
	                int left = n;
	                int right = n;
	                int len = 1;
	                if (currLen.containsKey(n-1)&&currLen.containsKey(n+1)) {
	                    left = leftEnd.get(n-1);
	                    right = rightEnd.get(n+1);
	                    leftEnd.put(right, left);
	                    rightEnd.put(left,right);
	                    len = currLen.get(left)+currLen.get(right)+1;
	                    currLen.put(left,len);
	                    currLen.put(right,len);
	                   
	                } else if (currLen.containsKey(n-1)){// only left end exist
	                    left = leftEnd.get(n-1);
	                    rightEnd.put(left,n);
	                    len = currLen.get(left)+1;
	                    currLen.put(left,len);
	                   
	                } else if (currLen.containsKey(n+1)){// only left end exist
	                    right = rightEnd.get(n+1);
	                    leftEnd.put(right,n);
	                    len = currLen.get(right)+1;
	                    currLen.put(right,len);
	                    
	                } 
	                     currLen.put(n,len);
	                    rightEnd.put(n,right);
	                    leftEnd.put(n,left);
	                     longest = Math.max(longest,len);
	                
	            } else {// already has this number in map
	                
	            }
	        }
	        
	        return longest;
	    }
