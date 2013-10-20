//correct DP solution
// http://www.mitbbs.com/article_t/JobHunting/32547435.html 
//level 4

public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
    

/*pass the test, but the code is incorrect.

it will false the case "abcde" {"ab","cde","abc"}

at the case "abcdcef {"ab","cdc","ef","abc","cef"}

"*/


public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
          if (dict.size() == 0) return s.isEmpty();
        if (s.isEmpty()) return false;
        if (dict.contains(s)) return true;
        
        int l = s.length();
        while (l>0) {
        	int longest = -1;
        	
            for(String w : dict){
                int l2 = w.length();
                if (l2 > l) continue;
                if (s.substring(0,l2).equals(w)) {
                	if (l2 > longest) {
                		longest = l2;
            
                	}
                }
            }
            if (longest == -1) break;
            s = s.substring(longest);
            l = s.length();
        }
        
        return l==0;
    }
