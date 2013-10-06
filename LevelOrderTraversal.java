/*102.Binary Tree Level Order Traversal 
algorithm: BFS, add to path, until meets null, null is the marker at the end of each line.
data structure: queue*/


 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            //ret.add(new ArrayList<Integer>());
            return ret;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        q.add(null);
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            
            if (curr!=null){
                level.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            } else {
                ArrayList<Integer> copy = new ArrayList<Integer>(level);
                ret.add(copy);
                level.clear();
                if (!q.isEmpty())q.add(null);
            }
        }
        
        return ret;
    }
