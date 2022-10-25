class Solution {
    public boolean canJump(int[] nums) {
        boolean [] jump = new boolean[nums.length];
        jump[0] = true;
        for(int i=0; i<nums.length; i++) {
            if(jump[i] == true) {
                for(int j=1; j<=nums[i] && j+i < nums.length; j++) {
                    jump[j+i] = true;
                }
            }
        }
        return jump[nums.length-1];
    }
}