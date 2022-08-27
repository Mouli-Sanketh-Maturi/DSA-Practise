class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    floodFill(i,j,grid);
                }
            }
        }
        return count;
    }
    
    void floodFill(int i,int j,char[][] grid){
        if(i>=grid.length || j>= grid[0].length || i<0 || j<0 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        floodFill(i+1,j,grid);
        floodFill(i,j+1,grid);
        floodFill(i-1,j,grid);
        floodFill(i,j-1,grid);
    }
}