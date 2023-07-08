func reorderList(head *ListNode) {

	slow := head
	fast := head

	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}

	secondHead := slow.Next
	slow.Next = nil

	secondHead = reverseList(secondHead)

	mergeList(head, secondHead)

}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	next := head.Next
	end := reverseList(next)
	next.Next = head
	head.Next = nil
	return end
}

func mergeList(firstHead *ListNode, secondHead *ListNode) {

	firstPtr := firstHead
	secondPtr := secondHead

	for firstPtr != nil && secondPtr != nil {
		temp := firstPtr.Next
		firstPtr.Next = secondPtr
		firstPtr = temp
		temp = secondPtr.Next
		secondPtr.Next = firstPtr
		secondPtr = temp
	}

}

