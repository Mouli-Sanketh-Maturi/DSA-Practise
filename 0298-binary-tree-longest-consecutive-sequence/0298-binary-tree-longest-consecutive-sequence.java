
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
    int result = 0;
    
    public int longestConsecutive(TreeNode root) {
        largestConsecutive(root, 0, 0);
        return result;
    }

    public void largestConsecutive(TreeNode root, int parentVal, int currentSeq) {
        if(root == null) {
            return;
        }
        if(root.val == parentVal + 1) {
            currentSeq++;
        } else {
            currentSeq = 1;
        }

        result = Math.max(currentSeq, result);

        largestConsecutive(root.left, root.val, currentSeq);
        largestConsecutive(root.right, root.val, currentSeq);
    }
}