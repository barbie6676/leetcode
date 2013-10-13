/* very similiar to clone graph*/

public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if( head == null) return null;
        
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode headcopy = new RandomListNode(head.label);
        map.put(head,headcopy);
        
        RandomListNode p1 = head;
        RandomListNode p2 = headcopy;
        while(p1.next!=null) {
            if (map.containsKey(p1.next)) {
                p2.next = map.get(p1.next);
            } else {
                RandomListNode newNode = new RandomListNode(p1.next.label);
                p2.next = newNode;
                map.put(p1.next,newNode);
            }
            
            if (p1.random != null){
                if (map.containsKey(p1.random)) {
                    p2.random = map.get(p1.random);
                } else {
                    RandomListNode newNode = new RandomListNode(p1.random.label);
                    p2.random = newNode;
                    map.put(p1.random,newNode);
                }
            }
            p1 = p1.next;
            p2 = p2.next;
        }
         if (p1.random != null){
                if (map.containsKey(p1.random)) {
                    p2.random = map.get(p1.random);
                } else {
                    RandomListNode newNode = new RandomListNode(p1.random.label);
                    p2.random = newNode;
                    map.put(p1.random,newNode);
                }
            }
        return headcopy;
    }
