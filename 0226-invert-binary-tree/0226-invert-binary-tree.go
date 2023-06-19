/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    
    left := root.Left
    right := root.Right
    
    invertTree(left)
    invertTree(right)
    
    root.Right = left
    root.Left = right
    
    return root
}