class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1) {
                    int resultantArea = calculateArea(grid, i, j);
                    if(resultantArea > maxArea) {
                        maxArea = resultantArea;
                    }
                }
            }
        }
        return maxArea;
    }
    
    public int calculateArea(int[][] grid, int i, int j) {
        if(i >= grid.length || i<0){
            return 0;
        } else if(j >= grid[0].length || j<0){
            return 0;
        }
        int area = 0;
        if(grid[i][j] == 0){
            return area;
        } else {
            area += 1;
            grid[i][j] = 0;
        }
        area += calculateArea(grid, i+1, j);
        area += calculateArea(grid, i, j+1);
        area += calculateArea(grid, i-1, j);
        area += calculateArea(grid, i, j-1);
        return area;
    }
}