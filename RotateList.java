/*61. rotate lsit
algorithm: two pointers, break in the middle and rearrange.

*/

public ListNode rotateRight(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return head;
        if (n == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        int count = 0;
        while (p1.next != null){
            p1 = p1.next;
            count++;
        }
        
        int forward = n%count;
        
        count = 0;
        p1 = dummy;
        while (count < forward){
            p1 = p1.next;
            count++;
        }
        ListNode p2 = dummy;
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p1.next = dummy.next;
        dummy.next = p2.next;
        p2.next = null;
        return dummy.next;
    }
