/*38. count and say
recursion*/


 public String countAndSay(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 1) return "1";
        
        String before = countAndSay(n-1);
        String ret = "";
        for (int i = 0; i< before.length();i++) {
            char c = before.charAt(i);
            int j = i+1;
            int count = 1;
            while (j < before.length()&&before.charAt(j)==c){
                count ++;
                j++;
            }
            ret +=(char)(count+'0');
            ret += c;
            i = j -1;
        }
        
        return ret;
    }
