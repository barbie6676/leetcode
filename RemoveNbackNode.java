/*19*/

public ListNode removeNthFromEnd(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        int i = 0;
        while (i < n) {
            head = head.next;
            i++;
        }
        
        ListNode pointer = dummy;
        while (head.next!=null){
            head = head.next;
            pointer = pointer.next;
        }
        
        pointer.next = pointer.next.next;
        
        return dummy.next;
        
    }
