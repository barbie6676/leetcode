/*21. merge two sorted lists
 23. merge k sorted lists*/
 
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = lists.size();
        if (n == 0) return null;
        int i = 0;
        while(i < lists.size()) {
            if (lists.get(i)==null) {
                lists.remove(i);
            } else {
                i++;
            }
        }
        
        n = lists.size();
        if (n == 0) return null;
        if ( n== 1) return lists.get(0);
        
        while(lists.size()>1){
            ListNode l = mergeTwoLists(lists.get(0),lists.get(1));
            lists.set(0,l);
            lists.remove(1);
        }
        
        return lists.get(0);
    }
    

 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode dummy = new ListNode(-1);
        ListNode list = dummy;
        
        while (l1 !=null && l2 != null) {
            if (l1.val<l2.val) {
                list.next = l1;
                l1 = l1.next;
                
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        
        if (l1 != null) {
            list.next = l1;
        } else if (l2 != null){
            list.next = l2;
        }
        
        return dummy.next;
    }
