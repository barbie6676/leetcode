/*78 subsets.
algorithm: recursion, pickup the first elem of the current available numbers,
find the subsets of the rest elements, add them to the final result with and without the first elem.
*/


public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = S.length;
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (n == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        Arrays.sort(S);
        return subsetsAux(S,0);
       
        
    }
    
    public ArrayList<ArrayList<Integer>> subsetsAux(int[] S ,int start) {
         int n = S.length;
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (start == n) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        
        int head = S[start];
        ArrayList<ArrayList<Integer>> rest = subsetsAux(S,start+1);
        
        for (int i = 0; i < rest.size(); i++){
            ArrayList<Integer> elem = new ArrayList<Integer>();
            elem.add(head);
            elem.addAll(rest.get(i));
            ret.add(elem);
        }
        
        ret.addAll(rest);
        
        return ret;
        
    }
