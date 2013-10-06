/*94. inorder traversal
algorighm: DFS
data structure: stack
*/

public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> ret = new ArrayList<Integer>();
        
        if (root == null) return ret;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (root.left!=null){
            root = root.left;
            s.push(root);
        }
        
        while (!s.isEmpty()){
            TreeNode curr = s.pop();
            ret.add(curr.val);
            if (curr.right != null){
                TreeNode right = curr.right;
                s.push(right);
                while (right.left != null) {
                    right = right.left;
                    s.push(right);
                }
            }
        }
       
       return ret;
    }
