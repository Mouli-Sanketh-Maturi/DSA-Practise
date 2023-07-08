/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getVal(l1 *ListNode) int {
	if l1 == nil {
		return 0
	}
	return l1.Val
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	temp := &ListNode{0, nil}
	tempHead := temp

	carry := 0

	for l1 != nil || l2 != nil {

		val := getVal(l1) + getVal(l2) + carry

		if val >= 10 {
			val = val % 10
			carry = 1
		} else {
			carry = 0
		}

		temp.Next = &ListNode{val, nil}
        temp = temp.Next
        
		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}
	}

	if l1 == nil && l2 == nil && carry != 0 {
		temp.Next = &ListNode{carry, nil}
	}

	return tempHead.Next
}
