/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return findMinDepth(root, 0)
}

func findMinDepth(root *TreeNode, count int) int {
	if root.Left == nil && root.Right == nil {
		return count + 1
	}

	if root.Left == nil {
		return findMinDepth(root.Right, count+1)
	} else if root.Right == nil {
		return findMinDepth(root.Left, count+1)
	}

	return min(findMinDepth(root.Left, count+1), findMinDepth(root.Right, count+1))
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}