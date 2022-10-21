class Solution {
    public boolean checkValid(int[][] matrix) {
        boolean [] flagCheck = new boolean[matrix.length+1];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                flagCheck[matrix[i][j]] = true;
            }
            for(int j=1; j<= matrix.length; j++) {
                if(flagCheck[j] == false)
                    return false;
                flagCheck[j] = false;
            }
        }
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                flagCheck[matrix[j][i]] = true;
            }
            for(int j=1; j<= matrix.length; j++) {
                if(flagCheck[j] == false)
                    return false;
                flagCheck[j] = false;
            }
        }
        
        return true;
    }
}