/*24. swap nodes in pairs*/


public ListNode swapPairs(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode p = dummy;
        ListNode third = null;
        ListNode second = null;
        while (p.next!=null && p.next.next !=null) {
            second = p.next.next;
            third = second.next;
            second.next = p.next;;
            p.next = second;
            second.next.next = third;
            p = second.next;
        }
        
        return dummy.next;
    }
