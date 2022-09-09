class KthLargest {

    PriorityQueue<Integer> queue;
    int largest;
    
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        largest = k;
        for(int i=0; i<nums.length; i++){
            queue.add(nums[i]);
            if(queue.size() > k)
                queue.poll();
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size() > largest)
            queue.poll();
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */