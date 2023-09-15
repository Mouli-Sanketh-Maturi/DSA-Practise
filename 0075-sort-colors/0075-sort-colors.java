class Solution {
    public void sortColors(int[] nums) {
        int count1 = 0,count2 = 0,count0 = 0;

        for (int num : nums) {
            if (num == 1) {
                count1++;
            } else if (num == 2) {
                count2++;
            } else {
                count0++;
            }
        }

        int i = 0;

        while(i<count0) {
            nums[i++] = 0;
        }

        while(i<count1+count0) {
            nums[i++] = 1;
        }

        while(i<count0+count1+count2) {
            nums[i++]=2;
        }
    }
}