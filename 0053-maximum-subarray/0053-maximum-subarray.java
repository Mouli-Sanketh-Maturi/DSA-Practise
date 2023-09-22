class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int currSum = sum;
        for(int i=1; i<nums.length; i++) {
            if(currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            if(currSum > sum) {
                sum = currSum;
            }
        }
        return sum;
    }
}