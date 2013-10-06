/*111. Minimum Depth of Binary Tree
algorithm: null, think clear.
*/


 public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        if (isLeaf(root)) return 1;
        
        int left = root.left==null?Integer.MAX_VALUE:minDepth(root.left);
        int right = root.right==null?Integer.MAX_VALUE:minDepth(root.right);
        
        return (left<right?left:right)+1;
    }
    
    public boolean isLeaf(TreeNode root){
        return root==null?false:(root.right==null&&root.left==null);
    }
