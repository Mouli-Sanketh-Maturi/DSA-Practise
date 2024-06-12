class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] right = new int[n][n];
        int[][] left = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];
        int[][] bombs = new int[n][n];

        int maxPlus = 0;

        for(int i=0; i<mines.length; i++) {
            bombs[mines[i][0]][mines[i][1]] = 1;
        }

        for(int i=0; i<left.length; i++) {
            int k = 0;
            for(int j = 0; j<left[i].length; j++) {
                if(bombs[i][j] == 0) {
                    k++;
                } else {
                    k = 0;
                }
                left[i][j] = k;
            }
        }

        for(int i=0; i<right.length; i++) {
            int k = 0;
            for(int j = right[i].length-1; j>=0; j--) {
                if(bombs[i][j] == 0) {
                    k++;
                } else {
                    k = 0;
                }
                right[i][j] = k;
            }
        }

        for(int i=0; i<up[0].length;i++) {
            int k = 0;
            for(int j=0; j<up.length; j++) {
                if(bombs[j][i] == 0) {
                    k++;
                } else {
                    k=0;
                }
                up[j][i] = k;
            }
        }

        for(int i=0; i<down[0].length;i++) {
            int k = 0;
            for(int j=down.length-1; j>= 0; j--) {
                if(bombs[j][i] == 0) {
                    k++;
                } else {
                    k=0;
                }
                down[j][i] = k;
            }
        }

        for(int i=0; i<up.length; i++) {
            for(int j=0; j<up[0].length; j++) {
                maxPlus = Math.max(maxPlus, Math.min(Math.min(up[i][j], down[i][j]), Math.min(left[i][j], right[i][j])));
            }
        }

        return maxPlus;
        
    }
}