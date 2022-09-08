class MinStack {

    Integer min;
    Node head;
    
    public MinStack() {
        this.min = null;
        this.head = null;
    }
    
    public void push(int val) {
        if(head == null){
            this.head = new Node(val,null,null);
            this.min = val;
        } else {
            head.right = new Node(val,head,null);
            head = head.right;
            if(val < this.min)
                this.min = val;
        }
    }
    
    public void pop() {
        if(head == null)
            return;
        if(head.val.equals(this.min)){
            findMin(head.left);
        }
        head = head.left;
        if(head != null)
            head.right = null;
    }
    
    private void findMin(Node ptr){
        if(ptr == null){
            this.min = null;
            return;
        }
        int currentMin = ptr.val;
        while(ptr != null){
            if(ptr.val < currentMin)
                currentMin = ptr.val;
            ptr = ptr.left;
        }
        this.min = currentMin;
    }
    
    public int top() {
        if(head == null)
            return 0;
        return head.val;
    }
    
    public int getMin() {
        return this.min;
    }
}

class Node {
    
    Node right;
    Node left;
    Integer val;
    
    public Node(Integer val, Node left, Node right){
        this.left = left;
        this.right = right;
        this.val = val;
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */