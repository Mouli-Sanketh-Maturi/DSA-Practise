/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    
    if list1 == nil {
        return list2
    } else if list2 == nil {
        return list1
    }
    
    head := &ListNode{}
    currentNode := head
    
    for (list1 != nil) && (list2 != nil) {
        if list1.Val < list2.Val {
            currentNode.Next = list1
            list1 = list1.Next
            currentNode = currentNode.Next
        } else {
            currentNode.Next = list2
            list2 = list2.Next
            currentNode = currentNode.Next
        }
    }
    
    for list1 != nil {
        currentNode.Next = list1
        list1 = list1.Next
        currentNode = currentNode.Next
    }
    
    for list2 != nil {
        currentNode.Next = list2
        list2 = list2.Next
        currentNode = currentNode.Next
    }
    
    return head.Next
}