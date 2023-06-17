/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    
    temp := head.Next
    ret := reverseList(head.Next)
    temp.Next = head
    head.Next = nil
    return ret
}