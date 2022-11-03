class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rowList.add(i);
                    columnList.add(j);
                }
            }
        }
        
        for(int i : rowList) {
            for(int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        
        for(int j : columnList) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}