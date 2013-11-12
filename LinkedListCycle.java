/*Linked List Cycle I & II*/

// cycle I
public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
     
        
        while (p1.next != null&&p2.next!=null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p2==null) return false;
            if (p1 == p2) return true;
        }
        return false;
    }
    
// cycle II 

public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = p1;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) return null;
            p2 = p2.next;
            if (p1==p2) break;
        }
        if (p1 == null || p2 == null) return null;
        
        p1 = head;
        while (p1!=p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
