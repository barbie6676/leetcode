/*112.Path Sum 
algorithm: DFS,
data structure: recursion or stack

113. Path Sum II
algorithm: DFS, the only difference is that after add one number to path, before return you have to remove it.
*/



 public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return false;
        if (isLeaf(root)) return sum == root.val;
        
        if ( hasPathSum(root.left,sum-root.val)) return true;
        return hasPathSum(root.right,sum-root.val);
    }
  
 public boolean hasPathSumIteration(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return false;
        
        
        Stack<Elem> s = new Stack<Elem>();
        Elem r = new Elem(root,sum);
        s.push(r);
        while (!s.isEmpty()){
            Elem c = s.pop();
            if (isLeaf(c.node)&&c.node.val==c.currSum) return true;
            ;
            if (c.node.left!=null) s.push(new Elem(c.node.left,c.currSum - c.node.val));
            if (c.node.right!=null) s.push(new Elem(c.node.right,c.currSum - c.node.val));
        }
        return false;
    }
	
    public boolean isLeaf(TreeNode root){
        if (root == null) return false;
        return root.left==null&&root.right==null;
    }
	
	 public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        
         pathSumAux(ret,path, root,sum);
         
         return ret;
    }
    
     public void pathSumAux( ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> path, TreeNode root, int sum) {
         if (root == null) return;
         
         if (isLeaf(root)) {
             if (root.val == sum){
                 path.add(root.val);
                 ArrayList<Integer> copy = new ArrayList<Integer>(path);
                 ret.add(copy);
                 path.remove(path.size()-1);
             }
             
             return;
         } 
         
         path.add(root.val);
          pathSumAux(ret,path, root.left,sum-root.val);
          pathSumAux(ret,path, root.right,sum-root.val);
          
          path.remove(path.size()-1);
         
     }
