/*30. Substring with Concatenation of All Words
algorithm: hash word to count
*/

public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> ret = new ArrayList<Integer>();
        
        int n = L.length;
        if (n == 0) return ret;
        int m = L[0].length();
        if (m == 0) {
            for (int i = 0; i < S.length();i++)
                ret.add(i);
            return ret;
        }
        
        if (S.length() < m*n) return ret;
        
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        int[] count = new int[L.length];
        for (int i = 0; i < L.length ; i++){
            if (map.containsKey(L[i])) {
                //map.put(L[i],map.get(L[i])+1);
                count[map.get(L[i])]++;
            } else {
                map.put(L[i],i);
                count[i]++;
            }
        }
        
        for (int i = 0; i < S.length() - m*n+1; i++ ){
            String s = S.substring(i,i+m);
            if (!map.containsKey(s)) continue;
            //String list = S.substring(i,i+m*n);
            int j = 0;
            int[] copy = count.clone();
            for ( ; j < n; j++) {
                String curr = S.substring(i+j*m,i+(j+1)*m);
                if (!map.containsKey(curr))     break;
                if (copy[map.get(curr)] == 0)   break;
                copy[map.get(curr)]--;
            }
            
            if (j == n) ret.add(i);
        }
        
        return ret;
    }
