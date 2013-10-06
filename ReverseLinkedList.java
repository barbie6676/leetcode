/*92:. reverse linked list II
algorithm: one pass, in place, have to move two node at a time forward.
notice the leave one or two node in the end.
*/

 public ListNode reverseBetween(ListNode head, int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int i= 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = dummy;
        
        while (i < m) {
            tail = tail.next;
            i++;
        }
        ListNode first = tail.next;
        ListNode curr = tail.next;
        if (curr == null) return dummy.next;
        
        
        ListNode second = null;
        ListNode third = null;
        ListNode last = null;
        while (i < n){
            second = curr.next;
            curr.next = last;
            last = second;
            third = second.next;
            second.next = curr;
            curr = third;
            
            i += 2;
        }
        
        if (i >n){
            tail.next = second;
            first.next = third;
        } else if (i==n){
            
            tail.next = curr;
            first.next = curr.next;
            if (curr != first) curr.next = last;
            
        }
         
        
        return dummy.next;
        
        
    }
