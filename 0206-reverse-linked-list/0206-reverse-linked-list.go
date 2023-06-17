/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    if (head != nil) {
        head,end := reverse(head)
        head.Next = nil
        return end
    }
    return head
}

func reverse(currentNode *ListNode) (*ListNode,*ListNode) {
    var current,endNode *ListNode
    if(currentNode.Next != nil) {
        current,endNode = reverse(currentNode.Next)
        current.Next = currentNode
    } else {
        endNode = currentNode
    }
    return currentNode,endNode
}