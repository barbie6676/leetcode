/*104.Maximum Depth of Binary Tree */

 public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        
        if (isLeaf(root)) return 1;
        
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
    
    public boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return root.right==null&&root.left==null;
    }
