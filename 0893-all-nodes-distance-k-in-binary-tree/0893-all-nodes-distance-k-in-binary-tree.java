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

    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        distanceKCheck(root, target, k);
        return result;
    }

    public int distanceKCheck(TreeNode root, TreeNode target, int k) {
        if(root == null) {
            return -1;
        }
        
        if (root == target) {
            searchDown(root, k);
            return 1;
        }

        int left = distanceKCheck(root.left, target, k);
        int right = distanceKCheck(root.right, target, k);

        if(k == left || k == right) {
            result.add(root.val);
        }

        if(left >= 0) {
            searchDown(root.right, k-left-1);
            return left+1;
        }
        if(right >= 0) {
            searchDown(root.left, k-right-1);
            return right+1;
        }

        return -1;
    }

    public void searchDown(TreeNode root, int distance) {
        if(distance < 0 || root == null) {
            return;
        } else if(distance == 0) {
            result.add(root.val);
            return;
        } else {
            searchDown(root.left, distance-1);
            searchDown(root.right, distance-1);
        }
    }
}