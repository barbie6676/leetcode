/*87. scramble string
algorithm: recursion, at the beginning, decide whether anagrams first.
*/

public boolean isScramble(String s1, String s2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s1.equals(s2)) return true;
        if (!isAnagrams(s1,s2)) return false;
        
        for (int i = 1; i <s1.length();i++ ){
            String leftend1 = s1.substring(0,i);
            String leftend2 = s2.substring(0,i);
            String rightrest1 = s1.substring(i);
            String rightrest2 = s2.substring(i);
        
            String rightend2 = s2.substring(s2.length()-i);
        
            String leftrest2 = s2.substring(0,s2.length()-i);
            
            if (isScramble(leftend1,leftend2)&&isScramble(rightrest1,rightrest2)) {
                return true;
            } else if (isScramble(leftend1,rightend2)&&isScramble(rightrest1,leftrest2)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.isEmpty()&&s2.isEmpty()) return true;
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++){
            count[s1.charAt(i)]++;
        }
        
        for (int i = 0; i < s2.length();i++){
            if (count[s2.charAt(i)]==0) return false;
            count[s2.charAt(i)]--;
        }
        
        for (int i = 0; i < 256; i++){
            if (count[i]>0) return false;
        }
        
        return true;
		}
