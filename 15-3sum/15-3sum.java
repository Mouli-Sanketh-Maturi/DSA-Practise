class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            int low = i+1;
            int high = nums.length-1;
            
            while(low < high && nums[i] <= 0){
                if(nums[i] + nums[low] + nums[high] == 0){
                    List<Integer> sumList = new ArrayList<>();
                    sumList.add(nums[i]);
                    sumList.add(nums[low]);
                    sumList.add(nums[high]);
                    resList.add(sumList);
                    while(low+1 < nums.length && nums[low] == nums[low+1]){
                        low++;
                    }
                    while(high-1 > 0 && nums[high] == nums[high-1]){
                        high--;
                    }
                    high--;
                }
                else if(nums[i] + nums[low] + nums[high] < 0){
                    low++;
                }
                else if(nums[i] + nums[low] + nums[high] > 0){
                    high--;
                }
                while(i+1 < nums.length && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return resList;
    }
}