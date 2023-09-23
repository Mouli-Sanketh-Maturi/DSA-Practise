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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode nextPtr = result;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                nextPtr.next = list1;
                nextPtr = nextPtr.next;
                list1 = list1.next;
            } else {
                nextPtr.next = list2;
                nextPtr = nextPtr.next;
                list2 = list2.next;
            }
        }

        if(list1 != null) {
            nextPtr.next = list1;
        } else if(list2 != null) {
            nextPtr.next = list2;
        }

        return result.next;
    }
}