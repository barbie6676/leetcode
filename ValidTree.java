/*98. is Valid tree
algorithm: recusion (mark left end and right end)or inorder traversal
*/

 public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        
        return isValidBSTAux(root, 0,0,false, false);
    }
    
    public boolean isValidBSTAux(TreeNode root, int max, int min, boolean checkright, boolean checkleft){
        if (root == null) return true;
        if (checkright && root.val<=min) return false;
        if (checkleft && root.val>=max) return false;
        
        boolean isValidLeft = isValidBSTAux(root.left,root.val,min,checkright,true);
        if (!isValidLeft) return false;
        return isValidBSTAux(root.right,max,root.val,true,checkleft);
        
    }
