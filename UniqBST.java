/*95. Unique Binary Search Trees
  96. Unique Binary Search Trees II
  
  algorithm: both recursion*/

 public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int ret = 0;
        for (int i = 1; i<=n; i++){
            if (i == 1 || i == n) ret += numTrees(n-1);
            else ret+=numTrees(i-1)*numTrees(n-i);
        }
        return ret;
    }
	
public ArrayList<TreeNode> generateTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
       return generateTreesAux(1,n);
    }
	
public ArrayList<TreeNode> generateTreesAux(int start, int end) {
         ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        if (start == end) {
            TreeNode root = new TreeNode(start);
            ret.add(root);
            return ret;
        }
        
        for (int i = start; i <= end ; i++) {
            ArrayList<TreeNode> right = generateTreesAux(i+1,end);
            ArrayList<TreeNode> left = generateTreesAux(start,i-1);
            
            if (i == start){
              
                for (int j = 0; j<right.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.right = right.get(j);
                    ret.add(root); 
                }
                continue;
            } 
            if (i == end){
                
                 for (int j = 0; j<left.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    ret.add(root); 
                }
                continue;
            }
            
            for (int k = 0; k < left.size();k++){
                for (int j = 0; j<right.size();j++){
                    TreeNode root = new TreeNode(i);
                    root.right = right.get(j);
                    root.left = left.get(k);
                    ret.add(root); 
                }
            }
        }
       return ret;
    }  
	
