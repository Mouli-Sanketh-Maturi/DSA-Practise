class Solution {
    public Boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodeList = new Node[numCourses+1];
        for(int i=0; i< numCourses; i++)
            nodeList[i] = new Node(i);
        //Construct a Graph
        for(int i=0; i< prerequisites.length; i++) {
            nodeList[prerequisites[i][0]].addNeighbor(nodeList[prerequisites[i][1]]);
        }
        for(int i=0; i< numCourses; i++) {
            if(detectCycle(nodeList[i]))
                return false;
        }
        return true;
    }
    
    Boolean detectCycle(Node n) {
        if(n.isVisited)
            return false;
        if(n.beingVisited)
            return true;
        n.beingVisited = true;
        for(Node childNode: n.adjacencyList) {
            if(detectCycle(childNode)){
                return true;
            }
        }
        n.beingVisited = false;
        n.isVisited = true;
        return false;
    }
    
}

class Node {
        int label;
        Boolean beingVisited = false;
        Boolean isVisited = false;
        List<Node> adjacencyList = new ArrayList<>();
        
        public Node(int label) {
            this.label = label;
        }
        
        public void addNeighbor(Node n) {
            this.adjacencyList.add(n);
        }
    }