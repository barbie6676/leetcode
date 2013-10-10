 /*76. Minimum Window Substring
 algorithm: the diffult part of this question is to get O(n) time.
 Thanks to BreakDS, use two data structure to do this:
 a linked-list containing of the index of the characters in S which appear in T,
 a haspmap, mapping the character to a list of listNode, the list keeps the maximum length of the count of this char,
 listNodes points to the global linked-list where the index has this char.
 
 each time the list length in the hashmap overflow, poll the list, at the same same delete the node it points to in 
 the global linked-list.
 
 after all the characters have been included in the linkedlist, get the window by (i - head.val), update it if it's smaller.
 
 */
 
 
 
 public String minWindow(String S, String T) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 int s = S.length();
	        int t = T.length();
	        
	        if (s<t) return "";
	        //if (s==t) return S.equals(T)?S:"";
	        
	        int[] charCounts = new int[256];
	        for (int i = 0; i < t; i++){
	            charCounts[T.charAt(i)]++;
	        }
	        
	        //ListNode[] head = new ListNode[256];
	        HashMap<Integer,LinkedList<ListNode>> map = new HashMap<Integer,LinkedList<ListNode>>();
	        
	        int[] ret = new int[3];
	        ret[0] = Integer.MAX_VALUE; // length of the miniwindow
	        int start = 0;
	        ret[1] = start; // start index;
	        ret[2] = start; // end index;
	        
	        ListNode dummy = new ListNode(-1);
	        ListNode tail = dummy;
	        
	        for (int i = 0; i<s;i++) {
	            if (charCounts[S.charAt(i)] == 0) continue; // this character never appears in T
	            int c = S.charAt(i);
	            ListNode node = new ListNode(i);
                tail.next = node;
                tail = node;
                
	            if (!map.containsKey(c)) {
	                t--;
	               
	                //head[c] = node;
	                LinkedList<ListNode> list = new LinkedList<ListNode>();
	                list.add(node);
	                map.put(c,list);
	            } else if (map.get(c).size() < charCounts[c]){ // update
	                t--;
	              
	                map.get(c).add(node);
	            } else {
	                
	                ListNode head = map.get(c).poll();
	                if (tail == head.next) tail = head;
	                map.get(c).add(node);
	                
	                
	                int next = S.charAt(head.next.val);
	                if (map.containsKey(next)){
	                	int idx = map.get(next).indexOf(head.next);
	                	map.get(next).set(idx,head);
	                }
	                head.val=head.next.val;
	                head.next = head.next.next;
	                
	 
	                
	            }
	            
	            if (t == 0){
	                if (ret[0] > i - dummy.next.val){
	                    ret[0] = i - dummy.next.val;
	                    ret[1] = dummy.next.val;
	                    ret[2] = i +1;
	                }
	                
	            }
	        }
	        
	        return t==0?S.substring(ret[1],ret[2]):"";
	    }
