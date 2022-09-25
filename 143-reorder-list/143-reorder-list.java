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
    public void reorderList(ListNode head) {
        //Find mid point
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr != null){
            fastPtr = fastPtr.next;
            if(fastPtr != null && fastPtr.next != null){
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
        }
        
        //Split
        ListNode secondHead = slowPtr.next;
        
        //Break into two lists
        slowPtr.next = null;
        
        //Reverse second list
        ListNode currentNode = secondHead;
        ListNode prevNode = null; 
        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        
        secondHead = prevNode;
    
        //Merge the lists
        while(head != null && secondHead != null){
            ListNode temp1 = head.next;
            ListNode temp2 = secondHead.next;
            head.next = secondHead;
            secondHead.next = temp1;
            secondHead = temp2;
            head = temp1;
        }
    }
}