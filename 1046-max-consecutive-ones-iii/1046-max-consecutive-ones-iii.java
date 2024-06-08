class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0; //inclusive
        int right = 1; // exclusive
        int currentFlips = 0;
        int maxLength = 0;
        while(right <= nums.length) {
            if(nums[right-1] == 0) {
                if(currentFlips < k) {
                    currentFlips++;
                } else {
                    while (true) {
                        if(nums[left] == 0) {
                            left++;
                            break;
                        }
                        left++;
                    }
                }
            }
            maxLength = Math.max(maxLength, right-left);
            right++;
        }
        return maxLength;
    }
}