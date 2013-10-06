/*105. Construct Binary Tree from Preorder and Inorder Traversal */


public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = preorder.length;
        if (n == 0) return null;
        if (n == 1) return new TreeNode(preorder[0]);
        
        return buildTreeAux(preorder, 0,n,inorder , 0, n);
    }
    
    public TreeNode buildTreeAux(int[] preorder, int p1, int p2, int[] inorder,int i1, int i2 ) {
        if (p1 == p2) return null;
        if (p1 == p2 -1) return new TreeNode(preorder[p1]);
        
        int idx = findIndex(preorder[p1],inorder,i1,i2);
        
        TreeNode root = new TreeNode(preorder[p1]);
        root.left = buildTreeAux(preorder,p1+1, p1+1+idx-i1  ,inorder,i1,idx);
        root.right = buildTreeAux(preorder, p1+1+idx-i1  , p2, inorder,idx+1,i2);
        
        return root;
    }
    
    public int findIndex(int target, int[] inorder, int i1, int i2) {
        for (int i = i1; i < i2 ; i++){
            if (inorder[i]== target) return i;
        }
        
        return -1;
    }
