class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dupSet = new HashSet<>();
        Arrays.stream(nums).boxed()
            .forEach(i -> dupSet.add(i));
        if(dupSet.size() == nums.length){
            return false;
        }
        return true;
    }
}