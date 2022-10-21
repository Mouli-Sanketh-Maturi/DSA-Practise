class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> validationSet = new HashSet<>();
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                if(!validationSet.add("Found " + board[i][j] + " in row " + i))
                   return false;
                if(!validationSet.add("Found " + board[i][j] + " in column " + j))
                   return false;
                if(!validationSet.add("Found " + board[i][j] + " in block " + i/3 + "-" + j/3))
                   return false;
            }
            }
        }
        return true;
    }
}