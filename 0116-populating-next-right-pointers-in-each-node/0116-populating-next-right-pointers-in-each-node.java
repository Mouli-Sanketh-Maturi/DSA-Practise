/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Map<Integer, Node> levelMap = new HashMap<>();

    public Node connect(Node root) {
        return connect(root, 0);
    }

    public Node connect(Node root, Integer level) {
        if(root == null) {
            return root;
        }
        connect(root.right, level+1);
        connect(root.left, level+1);
        root.next = levelMap.get(level);
        levelMap.put(level, root);
        return root;
    }
}