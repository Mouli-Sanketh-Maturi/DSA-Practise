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
        Node ptr = head;
        Node copyPtr = null;
        Node copyPtrHead = null;
        Map<Node,Node> arbMap = new HashMap<>();
        while(ptr != null){
            if(copyPtr == null){
                copyPtr = new Node(ptr.val);
                copyPtrHead = copyPtr;
            } else {
                copyPtr.next = new Node(ptr.val);
                copyPtr = copyPtr.next;
            }
            arbMap.put(ptr,copyPtr);
            ptr = ptr.next;
        }
        
        copyPtr = copyPtrHead;
        ptr = head;
        while(copyPtr != null){
            copyPtr.random = arbMap.get(ptr.random);
            copyPtr = copyPtr.next;
            ptr = ptr.next;
        }
        return copyPtrHead;
    }
}