/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func kthSmallest(root *TreeNode, k int) int {
	return constructArray(root, []int{})[k-1]
}

func constructArray(root *TreeNode, sortedArray []int) []int {
	if root == nil {
		return sortedArray
	}
	sortedArray = constructArray(root.Left, sortedArray)
	sortedArray = append(sortedArray, root.Val)
	return constructArray(root.Right, sortedArray)
}