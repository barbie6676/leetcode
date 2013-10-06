/*101. is Symmetic tree
algorithm: recursion and iteration*
*/

public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        
        return isSymmetricAux(root,root);
     }
     
     public boolean isSymmetricAux(TreeNode left, TreeNode right){
         if (left == null&&right == null) return true;
         if (left == null&&right != null) return false;
         if (left != null&&right == null) return false;
         if (left.val!=right.val) return false;
         
         return isSymmetricAux(left.right,right.left)&&isSymmetricAux(left.left,right.right);
     }
	 
	 
	  public boolean isSymmetricIteration(TreeNode root) {
       if (root == null) return true;
       
        Stack<TreeNode> l = new Stack<TreeNode>();
        Stack<TreeNode> r = new Stack<TreeNode>();
        l.push(root);
        r.push(root);
        
        while(!l.isEmpty()){
            TreeNode left = l.pop();
            TreeNode right = r.pop();
            
            if (left.val!=right.val) return false;
            if (left.left!=null&&right.right!=null){
                l.push(left.left);
                r.push(right.right);
            } else if ((left.left!=null&&right.right==null)||(left.left==null&&right.right!=null)) {
                return false;
            }
            
            if (left.right!=null&&right.left!=null){
                l.push(left.right);
                r.push(right.left);
            } else if ((left.right!=null&&right.left==null)||(left.right==null&&right.left!=null)){
                return false;
            }
            
            
        }
        
        return true;
    }
