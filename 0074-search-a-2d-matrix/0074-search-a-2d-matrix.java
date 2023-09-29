class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findFloorRow(matrix,target);
        if (row == -1) {
            return false;
        }

        return findEleme(matrix[row], target);
    }

    public boolean findEleme(int[] array, int target) {
        int length = array.length;
        int low = 0;
        int high = length - 1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(array[mid] == target) {
                return true;
            } else if(array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }

        return false;

    }

    public int findFloorRow(int[][] matrix, int target) {
        int length = matrix.length;
        int low = 0;
        int high = length-1;
        int ans = -1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(matrix[mid][0] <= target) {
                ans = mid;
                low = low+1;
            }
            else if (matrix[mid][0] > target) {
                high = mid-1;
            }
        }
        return ans;
    }
}