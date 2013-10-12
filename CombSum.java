/*39. combination sum
algorithm: recursion, same elements can be used ulimited times.

40. combination sum II
add a counter.

*/


public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (candidates.length == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        Arrays.sort(candidates);
        return combinationSumAux(candidates, candidates.length-1,target);
    }
    
    public ArrayList<ArrayList<Integer>> combinationSumAux(int[] num, int idx, int target){
         ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        if (idx == -1) return null;
        
        for (int i = 0; i*num[idx]<=target;i++) {
            int rest = target - i*num[idx];
            ArrayList<ArrayList<Integer>> before = combinationSumAux(num,idx-1,rest);
            if (before != null) {
                for (int j = 0; j < before.size();j++) {
                    for(int k = 0; k < i; k++){
                        before.get(j).add(num[idx]);
                    }
                }
                ret.addAll(before);
            }
        }
        
        return ret;
    }
    
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        if ( n== 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        Arrays.sort(num);
        int[] count = new int[n];
        for (int i = n-1; i >=0; i--) {
            int j = i-1;
            while (j >= 0 &&num[j]==num[i]){
                count[i]++;
                j--;
            }
            i = j+1;
        }
        return combinationSumAux2(num,count, n-1,target);
    }
    
    public ArrayList<ArrayList<Integer>> combinationSumAux2(int[] num, int[] count, int idx, int target){
         ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        if (idx == -1) return null;
        
        
        for (int i = 0; i<=count[idx]+1;i++) {
            int rest = target - i*num[idx];
            if (rest >=0){
                ArrayList<ArrayList<Integer>> before = 
                          combinationSumAux2(num,count,idx-1-count[idx],rest);
                if (before != null) {
                    for (int j = 0; j < before.size();j++) {
                        for(int k = 0; k < i; k++){
                            before.get(j).add(num[idx]);
                        }
                    }
                    ret.addAll(before);
                }
            }
        }
        
        return ret;
    }
    
