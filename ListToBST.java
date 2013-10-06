  /*109. Convert Sorted List to Binary Search Tree
  algorithm: recursion*/
  
  public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        int n = 0; 
        ListNode count = head;
        while(count.next != null) {
            count = count.next;
            n ++;
        }
        
        int index = 0;
        count = head;
        while(index < n/2 -1){
            count = count.next;
            index++;
        }
        
        ListNode curr = count.next;
        TreeNode root = new TreeNode(curr.val);
        count.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(curr.next);
        return root;
    }
