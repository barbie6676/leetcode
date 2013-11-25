/*Sort a linked list in O(n log n) time using constant space complexity.*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = 0;
        ListNode p = head;
        
        while (p!= null) {
            p = p.next;
            n++;
        }
        
        if (n == 0 || n == 1) return head;
        
        int k = 0;
        p = head;
        while (k < n/2 -1){
            p = p.next;
            k++;
        }
        ListNode l1 = head;
        ListNode l2 = p.next;
        p.next = null;
        l1 = sortList(l1);
        l2 = sortList(l2);
        return merge(l1,l2);
    }
    
    public ListNode merge (ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode(-1);
        ListNode list = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
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
}
