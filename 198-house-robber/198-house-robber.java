class Solution {
    public int rob(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        if(nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        for(int i=2; i<nums.length; i++){
            queue.add(nums[i-2]);
            nums[i] += queue.peek();
        }
        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }
}