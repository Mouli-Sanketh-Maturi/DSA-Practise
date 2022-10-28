class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i=0; i <= maxJump && i < nums.length; i++) {
            maxJump = Math.max(maxJump, i+nums[i]);
        }
        if(nums.length -1 <= maxJump)
            return true;
        return false;
    }
}