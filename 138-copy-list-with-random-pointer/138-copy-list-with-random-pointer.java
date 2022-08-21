/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        //Copy the adjacent elements
        Node ptr = head;
        while(ptr != null){
            Node nextNode = ptr.next;
            ptr.next = new Node(ptr.val);
            ptr = ptr.next;
            ptr.next = nextNode;
            ptr = ptr.next;
        }
        
        //Copy the next random pointer
        ptr = head;
        while(ptr != null){
            Node random = ptr.random;
            ptr = ptr.next;
            if(random != null){
                ptr.random = random.next;
            }
            ptr = ptr.next;
        }
        
        //Seperate the list into two
        Node copiedHead = head.next;
        ptr = head;
        while(ptr != null){
            Node next = ptr.next;
            if(ptr.next != null)
                ptr.next = ptr.next.next;
            else
                ptr.next = null;
            if(ptr.next != null)
                next.next = ptr.next.next;
            else
                next.next = null;
            ptr = ptr.next;
        }
        return copiedHead;
    }
}