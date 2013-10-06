/*86.partition list
algorithm: two pointers, one keeps at the end of the list nodes less than x,
                         the other iterate to the end, if meeting a small one, pick it out add to the tail
						 */

public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
       // boolean firstlarge = true;
        ListNode tail = dummy;
        ListNode next = tail.next;
        while (next != null&&next.val<x){
            tail = tail.next;
            next = tail.next;
        }
        if (next == null) return dummy.next;
        ListNode curr= next;
       while (curr.next!=null) {
           if (curr.next.val>=x) {
               curr = curr.next;
               continue;
           }
          
           ListNode pickout = curr.next;
           curr.next = curr.next.next;
           pickout.next = tail.next;
           tail.next = pickout;
           tail = pickout;
       }
        
        return dummy.next;
        
    }
