/*16. longest common prefix*/

public String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String pre = "";
        if (strs.length == 0) return pre;
        if (strs.length == 1) return strs[0];
        
        int s= Integer.MAX_VALUE;
        
        for (int i = 0; i < strs.length ; i++) {
            if (strs[i].length()<s) s = strs[i].length();
        }
        if (s == 0) return pre;
        
        for (int j =0 ; j < s; j++) {
            char c = strs[0].charAt(j);
            int i = 1;
            for (; i < strs.length; i++){
                if (strs[i].charAt(j)!=c) break;
            }
            if (i < strs.length) return pre;
            pre += c;
        }
        
        return pre;
    }
