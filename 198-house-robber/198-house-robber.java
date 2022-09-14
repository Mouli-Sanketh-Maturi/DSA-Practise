class Solution {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        if(nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i=2; i<nums.length; i++){
            queue.add(dp[i-2]);
            dp[i] = queue.peek() + nums[i];
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
}