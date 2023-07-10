/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Neighbors []*Node
 * }
 */

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}

	cloneMap := make(map[*Node]*Node)
	clonedNode := cloneGraphImpl(node, cloneMap)

	return clonedNode
}

func cloneGraphImpl(node *Node, cloneMap map[*Node]*Node) *Node {
	newNode := new(Node)
	newNode.Val = node.Val
	cloneMap[node] = newNode

	for _, neighborNode := range node.Neighbors {
		if cloneMap[neighborNode] == nil {
			cloneGraphImpl(neighborNode, cloneMap)
		}
	}

	for _, neighborNode := range node.Neighbors {
			newNode.Neighbors = append(newNode.Neighbors,cloneMap[neighborNode])
	}

	return newNode
}
