/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 import "math"
func isValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return isValidBSTCheck(root.Left, math.MinInt, root.Val) && isValidBSTCheck(root.Right, root.Val, math.MaxInt)
}

func isValidBSTCheck(root *TreeNode, min, max int) bool {
	if root == nil {
		return true
	}
	if root.Val <= min || root.Val >= max {
		return false
	}
	return isValidBSTCheck(root.Left, min, root.Val) && isValidBSTCheck(root.Right, root.Val, max)
}