/*110. balances binary tree
*/

public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root== null) return true;
        if (!isBalanced(root.left)) return false;
        if (!isBalanced(root.right)) return false;
        
        return Math.abs(depth(root.left)-depth(root.right))<=1;
    }
    
    public int depth(TreeNode root){
        if (root == null) return 0;
        int right = depth(root.right);
        int left = depth(root.left);
        return (right>left?right:left)+1;
    }
