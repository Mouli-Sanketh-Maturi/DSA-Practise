class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        int leftSum = 0;
        if(sum - nums[0] == 0){
            return 0;
        }
        for(int i=0; i<nums.length-1; i++){
            leftSum += nums[i];
            if(leftSum *2 == sum - nums[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}