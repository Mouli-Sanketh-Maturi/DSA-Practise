class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;

    }

    public void mergeSort(int[] nums, int start, int end) {
        
        if(start >= end) {
            return;
        }
        
        int mid = start + (end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);

        int[] sorted = new int[(end-start)+1];

        int i = start;
        int j = mid+1;
        int k = 0;

        for(; i<=mid&&j<=end; k++) {
            if(nums[i] < nums[j]) {
                sorted[k] = nums[i];
                i++;
            } else {
                sorted[k] = nums[j];
                j++;
            }
        }

        while(i<=mid) {
            sorted[k++] = nums[i++];
        }

        while(j<=end) {
            sorted[k++] = nums[j++];
        }

        for(k=start;k <= end; k++) {
            nums[k] = sorted[k-start];
        }

    }
}