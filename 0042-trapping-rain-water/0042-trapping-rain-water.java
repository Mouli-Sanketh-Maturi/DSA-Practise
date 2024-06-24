class Solution {
    public int trap(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length-1;

        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];

        int water = 0;

        while(leftIndex < rightIndex) {
            if(height[leftIndex] < height[rightIndex]) {
                water += leftMax - height[leftIndex];
                leftIndex++;
            } else {
                water += rightMax - height[rightIndex];
                rightIndex--;
            }
            leftMax = Math.max(leftMax, height[leftIndex]);
            rightMax = Math.max(rightMax, height[rightIndex]);
        }

        return water;
    }
}