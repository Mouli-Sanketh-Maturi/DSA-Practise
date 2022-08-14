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
        ListNode mergedHead = null;
        ListNode ptr = null;
        if(list1 == null){
            return list2;
        } else if(list2 == null){
            return list1;
        }
        while(list1 != null || list2 != null){
            if(list1 == null){
                ptr.next = list2;
                list2 = null;
            } else if (list2 == null){
                ptr.next = list1;
                list1 = null;
            } else if(list1.val <= list2.val){
                if(mergedHead == null){
                    mergedHead = list1;
                    ptr = mergedHead;
                } else {
                    ptr.next = list1;    
                    ptr = ptr.next;
                }
                list1 = list1.next;
            } else {
                if(mergedHead == null){
                    mergedHead = list2;
                    ptr = mergedHead;
                } else {
                    ptr.next = list2;  
                    ptr = ptr.next;
                }
                list2 = list2.next;
            }
        }
        return mergedHead;
    }
}