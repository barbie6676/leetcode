/*89.Gray Code 
algorithm: recursion, repeat the transition of n-1 twice, put the transition at the n bit in the middle.
*/

 public ArrayList<Integer> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (n == 0){
            ret.add(0);
            return ret;
        } 
        ArrayList<Integer> transitions = grayCodeTrans(n);
        int[] binary = new int[n];
        ret.add(binToDeci(binary));
        for (int i = 0; i < transitions.size();i++){
            int bit = transitions.get(i);
            binary[bit] = 1- binary[bit];
            ret.add(binToDeci(binary));
        }
        
        return ret;
    }
    
    public ArrayList<Integer> grayCodeTrans(int n){
        ArrayList<Integer> trans = new ArrayList<Integer>();
        if (n == 1) {
            trans.add(0);
            return trans;
        }
        
        ArrayList<Integer> oneless = grayCodeTrans(n-1);
        trans.addAll(oneless);
        trans.add(n-1);
        trans.addAll(oneless);
        
        return trans;
        
    }
    
    public int binToDeci(int[] binary) {
        int ret = 0;
        for (int i = 0; i < binary.length; i++) {
            ret += binary[i]*Math.pow(2,i);
        }
        return ret;
    }
