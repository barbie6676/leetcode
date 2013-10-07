/*82.Remove Duplicates from Sorted List 
algorithm: two pointers

83. Remove Duplicates from Sorted List II
algorithm: keep the count of each number , if 1, move to next, if >1 skip all of them
*/

public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null;
        
        //ListNode dummy = new ListNode(-1);
        //dummy.next = head;
        
        ListNode curr = head;
        while(curr.next!=null){
            ListNode pointer = curr.next;
        
            while (pointer != null&&pointer.val == curr.val){
                pointer = pointer.next;
            }
            curr.next = pointer;
            if (pointer == null) break;
            curr= curr.next;
        }
        
       return head;
    }
	
	
	 public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null || head.next==null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pointer = dummy;
        
        while(pointer.next !=null) {
            ListNode curr = pointer.next;
            
            int count = 0;
            while (curr.next != null && curr.next.val==first.val){
                curr = curr.next;
                count ++;
            }
            if (count == 0) {
                pointer = curr;
            } else {
                pointer.next = curr.next;
            }
        }
        
        return dummy.next;
    }