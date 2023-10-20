/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;

        while(d1 != d2) {
            d1 = (d1 != null) ? d1.next : headA;
            d2 = (d2 != null) ? d2.next : headB;
        }

        return d1;
    }
}