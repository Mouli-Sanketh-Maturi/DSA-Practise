class Solution {
    public void rotate(int[] nums, int k) {
        int rotatedNums [] = new int[nums.length];
        for(int i=0; i<nums.length ;i++){
            rotatedNums[(i+k)%nums.length] = nums[i];
        }
        for(int i=0; i<nums.length ;i++){
            nums[i] = rotatedNums[i];
        }
    }
}