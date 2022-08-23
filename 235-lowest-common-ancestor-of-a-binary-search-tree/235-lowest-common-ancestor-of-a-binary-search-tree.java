/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestAncestor(root,p,q);
    }
    
    TreeNode findLowestAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p){
            return p;
        } else if (root == q){
            return q;
        }
        if((p.val < root.val && q.val > root.val ) || (q.val < root.val && p.val > root.val )){
            return root;
        } else if ( p.val > root.val && q.val > root.val) {
            return findLowestAncestor(root.right, p, q);
        } else {
            return findLowestAncestor(root.left, p, q);
        }
    }
}