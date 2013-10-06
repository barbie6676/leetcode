/*108. sorted Array to Binary search tree*/

public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        
        if (n == 0) return null;
        
        return sortedArrayToBSTAux(num,0,n);
    }
    
    public TreeNode sortedArrayToBSTAux(int[] num, int start, int end){
        if (start == end) return null;
        if (start == end -1) return new TreeNode(num[start]);
        
        int mid = start+(end-start)/2;
        
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTAux(num,start,mid);
        root.right = sortedArrayToBSTAux(num,mid+1,end);
        
        return root;
    }
