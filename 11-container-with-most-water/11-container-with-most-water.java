class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxArea = 0;
        while(i<j){
            int k = 0;
            if(height[i]>height[j]) {
                k = j;
            }
            else {
                k = i;
            }
            int area = (j-i)*height[k];
            if(area>maxArea){
                maxArea = area;
            }
            if(height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}