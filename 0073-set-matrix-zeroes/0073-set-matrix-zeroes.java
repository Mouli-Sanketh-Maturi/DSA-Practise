class Solution {
    public void setZeroes(int[][] matrix) {

        Boolean setFirstRow = false;
        Boolean setFirstColumn = false;

        for(int i=0; i<matrix.length;i++) {
            for(int j=0; j<matrix[i].length;j++) {
                if(matrix[i][j] == 0) {
                    if (i == 0 || j == 0) {
                        if (i == 0) {
                            setFirstRow = true;
                        }
                        if (j == 0) {
                            setFirstColumn = true;
                        }
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int i=1;i<matrix.length;i++) {
            if(matrix[i][0] == 0) {
                for(int j=0; j<matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=1;j<matrix[0].length;j++) {
            if(matrix[0][j] == 0) {
                for(int i=0; i<matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (setFirstColumn) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (setFirstRow) {
            for(int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}