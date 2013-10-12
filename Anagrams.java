/*49. anagrams.
thanks to BreakDS
algorithm: hashmap, and fingerprint function, max_value of long is 2^64-1, 4^32-1, 
if we use 0, 1,2,3 to mark characters's counts and a long value can hold the counts of 26 lower cases,
extra bits can be used to record length of strings.

hash long key to index of the word,
add it to result if there are multiple words with the same key
*/

public ArrayList<String> anagrams(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> ret = new ArrayList<String>();
        
        if (strs.length <=1) return ret;
        
        HashMap<Long, ArrayList<Integer>> count = new HashMap<Long, ArrayList<Integer>>();
        
        for (int i = 0; i < strs.length; i++ ) {
            long key = fingerprint(strs[i]);
            if (count.containsKey(key)) {
                if (count.get(key).size()==1) ret.add(strs[count.get(key).get(0)]);
                ret.add(strs[i]);
                count.get(key).add(i);
            } else {
                ArrayList<Integer> idx = new ArrayList<Integer>();
                idx.add(i);
                count.put(key,idx);
            }
        }
        
        return ret;
    }
    
    public long fingerprint(String s) {
        int total = s.length();
        int[] tri = new int[3];
        for (int i = 0; i < 3 ; i++) {
            tri[i] = total/(int)Math.pow(4,2-i);
            total %= (int)Math.pow(4,2-i);
        }
        
        int[] count = new int[26];
        for (int i = 0 ; i < s.length() ; i++){
            if (count[s.charAt(i)-'a']<3) count[s.charAt(i)-'a']++;
        }
        
        long function = 0;
        
        for (int i = 0; i<26;i++) {
            function += (long)Math.pow(4,i)*count[i];
        }
        
        for (int i = 0 ; i < 3; i++) {
            function += (long)Math.pow(4,i+26)*tri[i];
        }
        
        return function;
    }
