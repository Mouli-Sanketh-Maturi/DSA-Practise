class Solution {
    public void sortColors(int[] nums) {
        // Dutch National Flag
        // 0 ...... low-1 -> 0 Extreme Left
        // low .... mid-1 -> 1
        // high+1 ... n-1 -> 2 Extreme Right
        // mid ..... high -> Unsorted

        int low = 0,mid = 0,high = nums.length-1;

        while (mid <= high) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

    }
}