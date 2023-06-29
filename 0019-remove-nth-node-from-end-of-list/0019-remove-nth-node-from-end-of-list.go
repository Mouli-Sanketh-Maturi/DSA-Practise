/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    h := head
    ptr := head
    
    for i:=0; i<n; i++ {
        ptr = ptr.Next
    }
    
    if ptr == nil {
        return head.Next
    }
    
    for ptr.Next != nil {
        ptr = ptr.Next
        head = head.Next
    }
    
    head.Next = head.Next.Next
    
    return h
    
}