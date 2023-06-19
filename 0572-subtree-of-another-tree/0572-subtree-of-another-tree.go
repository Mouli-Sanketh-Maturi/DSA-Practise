/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
    if root == nil {
        return false
    }
    
    if root.Val == subRoot.Val {
        if isSameTree(root, subRoot) {
            return true
        }
    }
    
    return isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
}

func isSameTree(p *TreeNode, q *TreeNode) bool {
    if p == nil {
        if q == nil {
            return true
        }
        return false
    } else if q == nil {
        return false
    }
    return (p.Val == q.Val) && isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}