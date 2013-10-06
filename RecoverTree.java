/*99.Recover Binary Search Tree 
algorithm: DFS inorder traversal
*/


public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        
        while (root.left!=null){
             s.push(root);
            root = root.left;
           
        }
        s.push(root);
        TreeNode tail = root;
        TreeNode strange = root;
        TreeNode strange2= root;
        TreeNode curr = root;
        boolean  first = true;
        while(!s.isEmpty()){
            curr = s.pop();
            if (curr.val<tail.val) {
                if (first) {
                    strange = tail;
                    strange2 = curr;
                    first = false;
                } else {
                    int temp = curr.val;
                    curr.val = strange.val;
                    strange.val = temp;
                    first = true;
                    break;
                }
            }
            
            if (curr.right != null){
                TreeNode right = curr.right;
                while (right.left!=null){
                    s.push(right);
                    right = right.left;
                }
                s.push(right);
            }
            
            tail = curr;
        }
        
        if (!first){
            int temp = strange2.val;
            strange2.val = strange.val;
            strange.val = temp;
            first = true;
        }
    }
