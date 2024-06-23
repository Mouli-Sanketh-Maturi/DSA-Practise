class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                if(k+1 < nums.length && nums[k+1] == nums[k]) {
                    k--;
                    continue;
                }
                int sum = nums[j] + nums[k];
                if(nums[i] + sum == 0) {
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[i]);
                    current.add(nums[j]);
                    current.add(nums[k]);
                    result.add(current);
                    j++;
                } else if (nums [i] + sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}