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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Boolean noLoop = false;
        do {
            if(slow != null){
                slow = slow.next;
            }
            if(fast != null && fast.next != null){
                fast = fast.next.next;
            } else {
                noLoop = true;
                break;
            }
        } while(slow != fast);
        if(noLoop)
            return false;
        if(slow == fast)
            return true;
        else
            return false;
    }
}