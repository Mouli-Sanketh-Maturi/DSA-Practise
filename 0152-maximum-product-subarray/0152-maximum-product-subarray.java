class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int maxProduct = nums[0];

        for(int i=0; i<length; i++) {
            int product = 1;
            for(int j=i; j<length; j++) {
                product = product * nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        
        return maxProduct;
    }
}