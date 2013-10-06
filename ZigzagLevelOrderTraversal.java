 /*103. Binary Tree Zigzag Level Order Traversal 
 algorithm : BFS, record level index
 
 *//
 
 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ret;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        int index = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            
            if (curr!=null){
                level.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            } else {
                ArrayList<Integer> copy = new ArrayList<Integer>();
                if (index%2==0) {
                    copy.addAll(level);
                } else{
                   
                    for (int i = level.size()-1;i>= 0; i--){
                        copy.add(level.get(i));
                    }
                }
                ret.add(copy);
                index ++;
                level.clear();
                
                if (!q.isEmpty()) q.add(null);
            }
        }
		return ret;
		}
