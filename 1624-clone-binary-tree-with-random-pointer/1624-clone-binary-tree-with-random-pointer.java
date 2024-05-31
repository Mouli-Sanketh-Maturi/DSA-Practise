/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) {
            return null;
        }
        Map<Node,NodeCopy> nodeMap = new HashMap<>();
        NodeCopy newRoot = copyNode(root, nodeMap);
        return newRoot;
    }

    public NodeCopy copyNode(Node root, Map<Node,NodeCopy> nodeMap) {
        if(root == null) {
            return null;
        } else if(nodeMap.containsKey(root)) {
            return nodeMap.get(root);
        }
        NodeCopy newNode = new NodeCopy(root.val);
        nodeMap.put(root, newNode);
        newNode.left = copyNode(root.left, nodeMap);
        newNode.right = copyNode(root.right, nodeMap);
        newNode.random = copyNode(root.random, nodeMap);
        return newNode;
    }
}