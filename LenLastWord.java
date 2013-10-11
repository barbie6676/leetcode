/*58. length of the last word
algorithm: iterate string from back to front.

*/

public int lengthOfLastWord(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = s.length();
        if (len == 0) return 0;
        
        boolean space = true;
        
        int i = len -1;
        int ret = 0;
        while( i >= 0) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (space) {
                    i--;
                    continue;
                } else {
                    return ret;
                }
            } else {
                space = false;
                ret++;
            }
            
            i--;
        }
        return space?0:ret;
    }
