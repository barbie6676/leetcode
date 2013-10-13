 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
            
        int overflow = 0;
        
        while(l1!=null&&l2!=null){
            int v = l1.val+l2.val+overflow;
            ListNode node = new ListNode(v%10);
            overflow = v/10;
            l1 = l1.next;
            l2 = l2.next;
            p.next = node;
            p = p.next;
        }
        ListNode l = l1==null?l2:l1;
        while(l!=null){
            int v = l.val + overflow;
            ListNode node = new ListNode(v%10);
            overflow = v/10;
            l = l.next;
            p.next = node;
            p = p.next;
        }
        if (overflow==1){
            ListNode last = new ListNode(1);
            p.next = last;
        }
        
        return dummy.next;
        
    }
        
