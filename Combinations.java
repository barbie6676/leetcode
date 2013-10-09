 /*77. combinations
 algorithm: recursion, the combination (n,k) comes from two parts, combinations(n-1,k) and 
 combinations(n-1,k-1) plus n itself.
 */
 
 
 
 public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (k>n)  return ret;
        if (k == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        if (k == n) {
            ArrayList<Integer> elem = new ArrayList<Integer>();
            for (int i = 1; i<=n; i++){
                elem.add(i);
            }
            ret.add(elem);
            return ret;
        }
        
        ArrayList<ArrayList<Integer>> rest = combine(n-1,k-1);
        for (int i = 0; i < rest.size() ; i ++){
            rest.get(i).add(n);
            ret.add(rest.get(i));
        }
        ret.addAll(combine(n-1,k));
        
        return ret;
       
    }
