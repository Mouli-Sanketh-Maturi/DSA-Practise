/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode result = reverseTheList(head);
        head.next = null;
        return result;
        
    }

    public ListNode reverseTheList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode reversedHead = reverseList(head.next);

        head.next.next = head;

        return reversedHead;
        
    }
}