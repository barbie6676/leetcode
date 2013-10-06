/*129. Sum root to leaf numbers
algorithm:
	DFS. recursion or iteration
Data structure:
        recursion: two ints: prev and sum, if leaf, update sum, if not, update prev,
        iteration: stack, if leaf, add result to sum, if not, update root.val,

*/

	public int sumNumbersIter(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root)) return root.val;
        Stack<TreeNode> s = new Stack<TreeNode>();
        int sum = 0;
        s.push(root);
        
        while (!s.isEmpty()){
            
            TreeNode curr = s.pop();
            int prev = curr.val;
            
            if (curr.left != null) {
                if (isLeaf(curr.left)) {
                    sum += prev*10 + curr.left.val;
                } else {
                    curr.left.val += prev*10;
                    s.push(curr.left);
                }
            }
            
            if (curr.right != null) {
                if (isLeaf(curr.right)) {
                    sum += prev*10 + curr.right.val;
                } else {
                    curr.right.val += prev*10;
                    s.push(curr.right);
                }
            }
        }
        
        return sum;
        
    }
 public boolean isLeaf(TreeNode root) {
	        if (root == null) return false;
	        return (root.left == null && root.right == null);
	    }
		
		
public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sumAllPaths(root, 0, 0);
    }
    
    public int sumAllPaths(TreeNode root, int prev, int sum) {
        if (root == null) return 0;
        prev = prev*10 + root.val;
        
        if (root.left == null && root.right == null) {
            return prev + sum;
        }
        
        if (root.left != null) {
            sum = sumAllPaths(root.left, prev, sum);
        }
        
        if (root.right != null) {
            sum = sumAllPaths(root.right, prev, sum);
        }
        
        return sum;
    }
	
	
