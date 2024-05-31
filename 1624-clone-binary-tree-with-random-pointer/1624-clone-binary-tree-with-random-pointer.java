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
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()) {
            Node ptr = nodeQueue.poll();
            if(ptr.random != null) {
                nodeMap.get(ptr).random = nodeMap.get(ptr.random);
            }
            if(ptr.left != null) {
                nodeQueue.offer(ptr.left);
            }
            if(ptr.right != null) {
                nodeQueue.offer(ptr.right);
            }
        }
        return newRoot;
    }

    public NodeCopy copyNode(Node root, Map<Node,NodeCopy> nodeMap) {
        if(root == null) {
            return null;
        } else if(nodeMap.containsKey(root)) {
            return nodeMap.get(root);
        }
        NodeCopy leftNode = null;
        NodeCopy rightNode = null;
        if(root.left != null) {
            leftNode = copyNode(root.left, nodeMap);
            nodeMap.put(root.left, leftNode);
        }
        if(root.right != null) {
            rightNode = copyNode(root.right, nodeMap);
            nodeMap.put(root.right, rightNode);
        }
        NodeCopy newNode = new NodeCopy(root.val,leftNode ,rightNode , null);
        nodeMap.put(root, newNode);
        return newNode;
    }
}