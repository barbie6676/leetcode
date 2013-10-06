/*124. Binary Tree Maximum Path Sum
algorithm:  recursion; compare 6 values (left, right, root,left+root, right+root, left+right+root),update global maxsum, but only return the max of value including root (right + root, left+root, root)
data structure 
*/

 public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        
        int[] max = {Integer.MIN_VALUE};
        int left  = 0;
        int right = 0;
        int branch = 0;
        if (root.right == null ) {
            left = maxPathSumAux(max,root.left);
            branch = left;
        } else if (root.left == null)  {
            right = maxPathSumAux(max,root.right);
            branch = right;
        } else {
            left = maxPathSumAux(max,root.left);
            right = maxPathSumAux(max,root.right);
            branch = Math.max(left,right);
        }
        int sum = left+right+root.val;
        
        max[0] = Math.max(max[0],Math.max(sum,Math.max(Math.max(branch,branch+root.val),root.val)));
        
        
        return max[0];
    }
    
    public int maxPathSumAux(int[] max, TreeNode root) {
        
        if (root.left == null && root.right == null) {
            //max[0] = Math.max(max[0],root.val);
            return root.val;
        }
        
        
        int left  = 0;
        int right = 0;
        int branch = 0;
        if (root.right == null ) {
            left = maxPathSumAux(max,root.left);
            branch = left;
        } else if (root.left == null)  {
            right = maxPathSumAux(max,root.right);
            branch = right;
        } else {
            left = maxPathSumAux(max,root.left);
            right = maxPathSumAux(max,root.right);
            branch = Math.max(left,right);
        }
        
        int sum = left+right+root.val;
      
        max[0] = Math.max(max[0],Math.max(sum,Math.max(Math.max(branch,branch+root.val),root.val)));
        
        
        return Math.max(branch+root.val,root.val);
    }
