/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    
    boolean isValidBST(TreeNode root, long upperBound, long lowerBound){
        if(root == null){
            return true;
        }
        if(root.right != null){
            if(root.right.val <= root.val || root.right.val >= upperBound || root.right.val <= lowerBound){
                return false;
            }
        }
        if(root.left != null){
            if(root.left.val >= root.val || root.left.val >= upperBound || root.left.val <= lowerBound){
                return false;
            }
        }
        return isValidBST(root.right,upperBound,root.val) && isValidBST(root.left,root.val,lowerBound);
    }
}