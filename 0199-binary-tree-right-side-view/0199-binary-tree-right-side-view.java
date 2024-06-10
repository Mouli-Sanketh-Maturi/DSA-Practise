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

    Map<Integer,Integer> levelMap = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 0);
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<levelMap.size(); i++) {
            result.add(levelMap.get(i));
        }
        return result;
    }

    public void rightSideView(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        rightSideView(root.left, level+1);
        levelMap.put(level, root.val);
        rightSideView(root.right, level+1);
    }
}