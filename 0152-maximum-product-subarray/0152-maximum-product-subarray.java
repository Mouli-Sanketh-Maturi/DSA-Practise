class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int maxProduct = nums[0];

        int prefix_prod = 1;
        int suffix_prod = 1;

        for(int i=0; i<length; i++) {
            prefix_prod *= nums[i];
            suffix_prod *= nums[length-i-1];

            maxProduct = Math.max(maxProduct, Math.max(prefix_prod, suffix_prod));

            if(nums[i] == 0) {
                prefix_prod = 1;
            } if(nums[length-i-1] == 0) {
                suffix_prod = 1;
            }

        }

        return maxProduct;
    }
}