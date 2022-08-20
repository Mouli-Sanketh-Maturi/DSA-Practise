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
    Map<Integer,List<Integer>> map = new LinkedHashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root,0);
        List<List<Integer>> resList = new ArrayList<>();
        for(List<Integer> res: map.values()){
            resList.add(res);
        }
        return resList;
    }
    
    void traverse(TreeNode root,int level){
        if(root == null)
            return;
        if(!map.containsKey(level)){
            List<Integer> resList = new ArrayList<>();
            resList.add(root.val);
            map.put(level,resList);
        } else {
            map.get(level).add(root.val);
        }
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}