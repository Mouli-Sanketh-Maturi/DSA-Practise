class Solution {
    
    static Boolean [][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum %2 != 0)
            return false;
        sum = sum/2;
        this.dp = new Boolean [sum+1][nums.length+1];
        return canPartition(nums, 0, sum, 0);
    }
    
    public boolean canPartition(int[] nums, int currentSum, int sum, int index) {
        if(currentSum == sum)
            return true;
        if(index >= nums.length || currentSum > sum) {
            return false;
        }
        if(this.dp[currentSum][index] != null)
            return this.dp[currentSum][index];
        this.dp[currentSum][index] = canPartition(nums, currentSum + nums[index], sum, index+1) ||
            canPartition(nums, currentSum, sum, index+1);
        return this.dp[currentSum][index];
    }
}