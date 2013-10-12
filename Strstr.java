/*28. Strstr(),
return the first substring of needle in haystack.

KMP algorithm, but I don't understand....

*/

public String strStr(String haystack, String needle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len1 = haystack.length();
        int len2 = needle.length();
      
        if (len1 < len2) return null;
        if (needle.isEmpty()) return haystack;           
                    
        // Compute the prefix function of Pattern            
        int[] prefixFunc = preFixFn( needle);            
         
        int matched = 0;     // Number of characters matched            
         
        for( int i=0; i<len1; i++ ) {   
            // if matched == 0 like start, not need to enter the loop
            // if matched > 0; but the two ends don't match
            // update the matched lenght;
        	while( matched>0 && needle.charAt(matched) != haystack.charAt(i) )            
        		matched = prefixFunc[matched-1]; 
            // if find a char matched here in haystack to the end of the already matched str.
            if( needle.charAt(matched)  == haystack.charAt(i) )            
                matched++;            
            if( matched == len2 )   
            	return haystack.substring(i - len2 +1);                   
        }  
        return null;
    }  
    
    public int[] preFixFn (String pattern) {
        
    	int len = pattern.length();
    	int[] prefix = new int[len];
    	
    	if (len <=1) return prefix;
    	
    	int longestleft = 0; //true postfix and the longest prefix's length
    	 //for a string of only one char, the longest prefix length has to be 0 before it must be a false postfix
    	 prefix[0] = 0;
    	
    	for (int matched = 1; matched <len  ; matched ++) {
    		while(longestleft > 0 && pattern.charAt(longestleft) != pattern.charAt(matched)) 
    			 longestleft = prefix[longestleft-1];    
    		 if( pattern.charAt(longestleft) == pattern.charAt(matched) )            
                 longestleft++;            
    		 
    		 prefix[matched] = longestleft;  
    	}
    	  	
    	return prefix;
    }
