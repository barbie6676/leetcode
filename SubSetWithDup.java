/*90. SubSets II
algorithm: sort first, and recusion returning the subsets of the rest elements.
*/

 public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            
            if (num.length == 0) {
                 ret.add(new ArrayList<Integer>());
                 return ret;
            }
         
            
            Arrays.sort(num);
            
            return subsetsWithDupAux(num,0);
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDupAux(int[] num,int start) {
        
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            
            if (num.length == start) {
                ret.add(new ArrayList<Integer>());
                return ret;
            }
            
            if (num.length == start+1) {
                ret.add(new ArrayList<Integer>());
                ArrayList<Integer> set = new ArrayList<Integer>();
                set.add(num[start]);
                ret.add(set);
                return ret;
            }
            
            
            int count = 1;
            for (int i = start+1;i < num.length && num[i]==num[i-1];i++){
                count ++;
            }
            
            ArrayList<ArrayList<Integer>> rest = subsetsWithDupAux(num,start+count);
            for (int i = 0; i < rest.size(); i++){
                for (int j = 1; j <= count; j++){
                    ArrayList<Integer> set = new ArrayList<Integer>(rest.get(i));
                    for (int k = 0; k < j;k++){
                        set.add(0,num[start]);
                    }
                    ret.add(set);
                }
            }
            
            ret.addAll(rest);
            
            return ret;
           
    }
