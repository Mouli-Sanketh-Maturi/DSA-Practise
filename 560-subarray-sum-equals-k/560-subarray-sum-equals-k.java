class Solution {
    public int subarraySum(int[] nums, int k) {
        int prevSum = 0;
        int count = 0;
        Map<Integer,Integer> sum = new HashMap<>();
        sum.put(0,1);
        for(int i=0; i<nums.length; i++){
            prevSum += nums[i];
            count += sum.getOrDefault(prevSum-k,0);
            if(sum.get(prevSum) == null)
                sum.put(prevSum,1);
            else{
                sum.put(prevSum,sum.get(prevSum)+1);
            }
        }
        return count;
    }
}