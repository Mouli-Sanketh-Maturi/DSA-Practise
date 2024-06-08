class Solution {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        for(int i=0; i+offset<nums.length;) {
            if (nums[i+offset] == 0) {
                offset++;
            } else {
                nums[i] = nums[i+offset];
                i++;
            }
        }
        for(int i=0; i<offset; i++) {
            nums[nums.length-i-1] = 0;
        }
    }
}