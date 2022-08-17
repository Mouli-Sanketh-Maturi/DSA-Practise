class Solution {
    public boolean containsDuplicate(int[] nums) {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashSet<Integer> set = new HashSet(numbers);
        if(set.size() == nums.length){
            return false;
        }
        return true;
    }
}