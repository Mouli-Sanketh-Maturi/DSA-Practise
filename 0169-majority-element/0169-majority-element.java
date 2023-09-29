class Solution {
    public int majorityElement(int[] nums) {
        int elem = nums[0];
        int count = 0;

        for(int num : nums) {
            if( elem == num) {
                count++;
            } else {
                if(count == 0) {
                    elem = num;
                    count++;
                } else {
                    count--;
                }
            }
        }

        return elem;
    }
}