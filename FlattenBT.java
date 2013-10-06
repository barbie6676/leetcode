 /*114. Flatten Binary Tree to Linked List 
 algorightm: Essencially it's preorder-travesal (head first, left child then right child), so DFS, record the tail, each time add the new node to its right and then
 mark its left as null
 
 data structure: stack
 
 */
 
 public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode tail = root;
        boolean first = true;
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            
            if (!first) {
                tail.right = curr;
                tail.left = null;
            }
             first = false;
            if (curr.right != null) s.push(curr.right);
            if (curr.left != null) {
                s.push(curr.left);
            }
            tail = curr;
        }
        
        return;
    }
