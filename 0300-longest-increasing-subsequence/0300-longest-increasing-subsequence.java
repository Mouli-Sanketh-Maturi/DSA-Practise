class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i=0; i<len; i++) {
            Arrays.fill(dp[i],-1);
        }
        return findMaxLength(-1,0,nums,dp);
    }

    public int findMaxLength(int currentSelection, int currentIndex, int[] nums, int[][] dp) {
        if(currentIndex == nums.length) {
            return 0;
        }

        if(currentSelection != -1 && dp[currentSelection][currentIndex] != -1) {
            return dp[currentSelection][currentIndex];
        }

        int notTake = 0 + findMaxLength(currentSelection, currentIndex+1, nums, dp);

        int take = 0;

        if(currentSelection < 0 || nums[currentIndex] > nums[currentSelection]) {
            take = 1 + findMaxLength(currentIndex, currentIndex+1, nums, dp);
        }

        if(currentSelection == -1) {
            return Math.max(take,notTake);
        } else {
            return dp[currentSelection][currentIndex] = Math.max(take,notTake);
        }
        
    }
}