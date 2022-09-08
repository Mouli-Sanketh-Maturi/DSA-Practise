class MinStack {

    Node head;
    
    public MinStack() {
        this.head = null;
    }
    
    public void push(int val) {
        if(head == null){
            this.head = new Node(val,null,null,val);
        } else {
            head.right = new Node(val,head,null,Math.min(head.min,val));
            head = head.right;
        }
    }
    
    public void pop() {
        if(head == null)
            return;
        head = head.left;
        if(head != null)
            head.right = null;
    }
    
    public int top() {
        if(head == null)
            return 0;
        return head.val;
    }
    
    public int getMin() {
        if(head == null)
            return 0;
        return head.min;
    }
}

class Node {
    
    Node right;
    Node left;
    Integer val;
    Integer min;
    
    public Node(Integer val, Node left, Node right, Integer min){
        this.left = left;
        this.right = right;
        this.val = val;
        this.min = min;
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