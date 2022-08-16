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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        ListNode lazyPtr = head;
        while(n > 0){
            ptr = ptr.next;
            n--;
        }
        if(ptr == null){
            return head.next;
        }
        while(ptr.next != null){
            ptr = ptr.next;
            lazyPtr = lazyPtr.next;
        }
        lazyPtr.next  = lazyPtr.next.next;
        return head;
    }
}