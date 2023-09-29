class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1=0,el2 = 0;
        int cnt1=0,cnt2 = 0;

        for(int num : nums) {
            if(el1 == num) {
                cnt1++;
            } else if(el2 == num) {
                cnt2++;
            } else if(cnt1 == 0) {
                el1 = num;
                cnt1++;
            } else if(cnt2 == 0) {
                el2 = num;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> finalNums = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;

        for(int num:nums) {
            if(num == el1) {
                cnt1++;
            } else if (num == el2) {
                cnt2++;
            }
        }
        if(cnt1 > nums.length/3) {
            finalNums.add(el1);
        }
        if(cnt2 > nums.length/3) {
            finalNums.add(el2);
        }

        return finalNums;
    }


}