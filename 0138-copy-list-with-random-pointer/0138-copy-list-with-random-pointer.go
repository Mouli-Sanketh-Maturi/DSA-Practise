/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {

	if head == nil {
		return head
	}

	originalHead := head

	for head != nil {
		copy := Node{head.Val, head.Next, head.Random}
		head.Next = &copy
        head = head.Next.Next
	}

	head = originalHead

	i := 1
	for head != nil {
		if i%2 == 0 {
			if head.Random != nil {
				head.Random = head.Random.Next
			}
		}
        head = head.Next
		i++
	}

	head = originalHead
	duplicateHead := originalHead.Next

	for head != nil {
		temp := head.Next
		head.Next = head.Next.Next
        if temp.Next != nil {
            temp.Next = temp.Next.Next
        }
		head = head.Next
	}

	return duplicateHead
}