class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr1 = 0;
        int arr2 = 0;
        int traversed = 0;
        int lastTraversed = 0;
        int lastlastTraversed = 0;
        while(traversed <= (nums1.length + nums2.length)/2){
            if( arr1 >= nums1.length || arr2 >= nums2.length){
                if(arr1 >= nums1.length){
                    arr2++;
                    lastlastTraversed = lastTraversed;
                    lastTraversed = 2;
                } else {
                    arr1++;
                    lastlastTraversed = lastTraversed;
                    lastTraversed = 1;
                }
            } else {
                if(nums1[arr1] >= nums2[arr2]){
                    arr2++;
                    lastlastTraversed = lastTraversed;
                    lastTraversed = 2;
                } else {
                    arr1++;
                    lastlastTraversed = lastTraversed;
                    lastTraversed = 1;
                }
            }
            traversed++;
        }
        if((nums1.length + nums2.length) %2 != 0){
            if(lastTraversed == 1){
                return nums1[arr1-1];
            } else {
                return nums2[arr2-1];
            }
        } else {
            int sum = 0;
            if(lastTraversed == 1){
                sum += nums1[arr1-1];
                arr1--;
            } else {
                sum += nums2[arr2-1];
                arr2--;
            }
            if(lastlastTraversed == 1){
                sum += nums1[arr1-1];
            } else {
                sum += nums2[arr2-1];
            }
            return sum/2.0f;
        }
    }
}