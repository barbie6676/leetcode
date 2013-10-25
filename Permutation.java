/*31. next permutation
algorithm: 1 find the last index that smaller than the next elem, if not found, swap the whole array ,call it i
           2 find the last index behind i that larger than num[i], call it j.
           3 swap the elements at i, j, swap the list after i,
           
this method will be used in the questions below.

60. permutation sequence
algorithm: I. you can directly use the nextPermutation methods
           II. there is also a recursion version based on the postion k comparing with n!, will implement later.
           
46. permutation
algorithm: can directly use nextPermutation.
           or can use recursion, each time pick up one elem, permute the rest, then insert the elem at each postion.
           
47. permutation II (unique permutations)
algorithm: use the nextPermutation,
           sort array first, add control, when the current perm is already non-ascending, stop and return result.
           
*/

 // first of all, still recursion is most straight forward
 // you pull out the elem at each position, 
 // permutate the rest of the elems , for each one, append the removed elem to the head,
 
 public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len == 0) {
        	ret.add(new ArrayList<Integer>());
        	return ret;
        }
          
        for (int i = 0 ; i < len ; i ++) {
            
            int curr = num[i];
            
            int[] rest = new int[len -1];
            int j = 0;
            int k = 0;
            while (k <len ) {
            	if(k != i) {
	                	rest[j] = num[k ]; 
	                	j++;
	                }
	             k++;   
                
            }
            
            ArrayList<ArrayList<Integer>> restList = permute(rest);
            
            for (int m = 0; m < restList.size(); m++) {
               
                    ArrayList<Integer> elem = new ArrayList<Integer>();
                    elem.add(curr);
                    elem.addAll(restList.get(m));
                    
                    ret.add(elem);
                    
            }
        }       
        return ret;
        
    }

 public void nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = num.length;
        
        if (n<=1) return;
        
        int lastsmall = -1;
        for (int i = 0; i < n-1 ; i++) {
            if (num[i]<num[i+1]) lastsmall = i;
        }
        
        if (lastsmall == -1) {
            //swap the whole array
            for (int i = 0; i < n/2; i++) {
                int temp = num[i];
                num[i] = num[n-1-i];
                num[n-1-i] = temp;
            }
            return;
        }
        
        int nextbig = lastsmall+1;
        int j = nextbig;
        while(j < n) {
            if (num[j]>num[lastsmall]) nextbig = j;
            j++;
        }
        
        int temp = num[lastsmall];
        num[lastsmall] = num[nextbig];
        num[nextbig] = temp;
        
      
        for (int i = lastsmall + 1; i < (n+lastsmall+1)/2 ; i++){
            temp = num[i];
                num[i] = num[n-(i-lastsmall)];
                num[n-(i-lastsmall)] = temp;
        }
    }
    
    public String getPermutation(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] num = new int[n];
        
        for (int i = 0; i < n; i++)
            num[i] = i+1;
          
        if (k>1){  
            for (int i = 0; i<k-1; i++)
                nextPermutation(num);
        }
            
        String s = "";
        for (int i = 0; i < n; i++)
            s += (char)(num[i]+'0');
            
        return s;
    } 
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = num.length;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (n == 0){
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        
        
        ArrayList<Integer> elem = new ArrayList<Integer>();
         for (int j = 0; j < n; j++){
                  elem.add(num[j]);
            }
        
        ret.add(elem);
        
        if (n == 1) return ret;
        
        int total = 1;
        for (int i = n; i >=1 ; i--){
            total *= i;
        }
            
            
        for (int i = 0; i < total-1; i++) {
            nextPermutation(num);
            ArrayList<Integer> perm = new ArrayList<Integer>();
            for (int j = 0; j < n; j++){
                  perm.add(num[j]);
            }
              
        
            ret.add(perm);
        }
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        int n = num.length;
        if (n == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        if (n ==1) {
            ArrayList<Integer> perm = new ArrayList<Integer>();
            perm.add(num[0]);
            ret.add(perm);
            return ret;
        }
        
        Arrays.sort(num);
        int lastsmall = -1;
        ArrayList<Integer> elem = new ArrayList<Integer>();
        for (int i = 0; i < n ; i++) {
            elem.add(num[i]);
            if (i < n-1&&num[i]<num[i+1]) lastsmall = i;
        }
        ret.add(elem);
        
        if (lastsmall == -1) return ret;
        
        while (true) { // may not be a very good flow control, but it works
            nextPermutation(num);
            ArrayList<Integer> perm = new ArrayList<Integer>();
            lastsmall = -1;
            for (int i = 0; i < n; i++){
                perm.add(num[i]);
                if (i < n-1 && num[i]<num[i+1]) lastsmall = i;
            }
            ret.add(perm);
            if (lastsmall == -1) break;
        } 
        
        return ret;
    }
