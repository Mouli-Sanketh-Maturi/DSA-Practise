class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums.length == 0){
            return new int[0];
        }
        //Find the first non negative integer
        int low = 0;
        int high = nums.length-1;
        int firstNonNegativeIndex = 0;
        if(nums[nums.length-1] < 0){
            firstNonNegativeIndex = nums.length;
        } else if(nums[0] >= 0){
            firstNonNegativeIndex = 0;
        } else
            while(low <= high){
                int mid = (low+high)/2;
                if(nums[mid] < 0){
                    low = mid+1;
                } else {
                    if(nums[mid-1] < 0){
                        firstNonNegativeIndex = mid;
                        break;
                    } else {
                        high = mid-1;
                    }
                }
            }
        
        int [] squares = new int[nums.length];
        int n = 0;
        int posIndex = firstNonNegativeIndex;
        int negIndex = firstNonNegativeIndex - 1;
        while(posIndex < nums.length && negIndex >=0){
            if(nums[posIndex]*nums[posIndex] < nums[negIndex]*nums[negIndex]){
                squares[n++] = nums[posIndex]*nums[posIndex];
                posIndex++;
            } else {
                squares[n++] = nums[negIndex]*nums[negIndex];
                negIndex--;
            }
        }
        
        while(posIndex < nums.length){
            squares[n++] = nums[posIndex]*nums[posIndex];
            posIndex++;
        }
        while(negIndex >= 0){
            squares[n++] = nums[negIndex]*nums[negIndex];
            negIndex--;
        }
        return squares;
    }
}