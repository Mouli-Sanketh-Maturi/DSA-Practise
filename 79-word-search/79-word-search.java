class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(searchDFS(board, words, i, j, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean searchDFS(char[][] board, char[] words, int i, int j, int k, boolean[][] visited) {
        if(i>= board.length || i < 0 || j>=board[i].length || j<0 || visited[i][j])
            return false;
        if(board[i][j] == words[k]) {
            visited[i][j] = true;
            if(k == words.length-1)
                return true;
            if(searchDFS(board, words, i+1, j, k+1, visited) ||
                searchDFS(board, words, i, j+1, k+1, visited) ||
                searchDFS(board, words, i-1, j, k+1, visited) ||
                searchDFS(board, words, i, j-1, k+1, visited)) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }
        return false;
    }
}