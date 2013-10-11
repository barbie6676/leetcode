/*65. Valid Number
algorithm: first of all, the information in the question is not that clear.
from the test cases: what is a valid num means:

only have space before or after string,

after e only integer,

sign at the begining of string or at the begining after e,

. can be at start, but has to be followed by digits.

given the detailed requirements above, write controls.

*/


public boolean isNumber(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = s.length();
        if (n == 0) return false;
        
        int i = 0;
        boolean hasdigit = false;
            boolean hase = false;
            boolean cansign = true;
            boolean candot = true;
            boolean space = true;
        while (i < n) {
            char c = s.charAt(i);
            
            if (c == ' '){
                if (!space) {
                    int j = i+1;
                    while (j<n&&s.charAt(j)==' '){
                        j++;
                    }
                    if (j == n) break;
                    return false;
                } 
            } else {
                	space = false;
            }
            
            if (c>='0'&&c<='9') {
            
                hasdigit = true;
                cansign = false;
            } else if (c=='e'){
            	
                if (hase||!hasdigit) return false;
                if (i == n-1) return false;
               
                hase = true;
                cansign = true;
                candot = false;
                hasdigit =false;
            } else if (c=='.'){
            	
                if (!candot) return false;
                
                candot = false;
                cansign = false;
            } else if (c=='+'||c=='-') {
                if (!cansign) return false;
                if (i == n-1) return false;
                cansign = false;
               
            } else if (c!=' '){
                return false;
            }
            
            i++;
        }
        
        return hasdigit;
    }
