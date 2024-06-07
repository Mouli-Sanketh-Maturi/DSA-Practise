class MaxStack {

    Set<Integer> deletedSet;
    Stack<int[]> elements;
    PriorityQueue<int[]> maxElements;
    int id;

    public MaxStack() {
        deletedSet = new HashSet<>();
        elements = new Stack<>();
        maxElements = new PriorityQueue<>( (a,b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        id = 0;
    }
    
    public void push(int x) {
        elements.add(new int[] {x,++id});
        maxElements.add(new int[] {x,id});
    }
    
    public int pop() {
        int[] result = elements.pop();
        while(deletedSet.contains(result[1])) {
            result = elements.pop();
        }
        deletedSet.add(result[1]);
        return result[0];
    }
    
    public int top() {
        int[] result = elements.peek();
        while(deletedSet.contains(result[1])) {
            elements.pop();
            result = elements.peek();
        }
        return result[0];
    }
    
    public int peekMax() {
        int[] result = maxElements.peek();
        while(deletedSet.contains(result[1])) {
            maxElements.poll();
            result = maxElements.peek();
        }
        return result[0];
    }
    
    public int popMax() {
        int[] result = maxElements.poll();
        while(deletedSet.contains(result[1])) {
            result = maxElements.poll();
        }
        deletedSet.add(result[1]);
        return result[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */