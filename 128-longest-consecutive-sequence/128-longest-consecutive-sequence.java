class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int num : nums)
            numsSet.add(num);
        int maxLength = 0;
        for(int num : nums) {
            if(!numsSet.contains(num-1)){
                int currentNum = num;
                int length = 0;
                while(numsSet.contains(num+length)){
                    length++;
                }
                maxLength = Math.max(length,maxLength);
            }
        }
        return maxLength;
    }
}