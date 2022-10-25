class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while( (high - low) > 1) {
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]) {
                if(nums[low] > nums[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
            } else {
                if(nums[low] > nums[high]){
                    high = mid;
                } else {
                    low = mid;
                }
            }
        }
        if(nums[low] < nums[high])
            return nums[low];
        return nums[high];
    }
}