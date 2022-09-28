class MedianFinder {
    
    Queue<Integer> minQueue;
    Queue<Integer> maxQueue;
    Boolean even;

    public MedianFinder() {
        minQueue = new PriorityQueue<>(Collections.reverseOrder());
        maxQueue = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        } else {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (minQueue.peek() + maxQueue.peek()) / 2.0d;
        } else {
            return maxQueue.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */