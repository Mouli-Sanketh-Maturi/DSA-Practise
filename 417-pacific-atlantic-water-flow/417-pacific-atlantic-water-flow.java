class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int [][] pacificFlood = new int[heights.length][heights[0].length];
        int [][] atlanticFlood = new int[heights.length][heights[0].length];
        
        List<List<Integer>> resultantList = new ArrayList<>();
        
        //Flood fill Atlantic ocean
        for(int i=0; i<heights[0].length; i++){
            floodFill(heights, atlanticFlood, heights.length-1, i, -1);
        }
        for(int i=0; i<heights.length; i++){
            floodFill(heights, atlanticFlood, i, heights[0].length-1, -1);
        }
        
        //Flood fill Pacific ocean
        for(int i=0; i<heights.length; i++){
            floodFill(heights, pacificFlood, i, 0, -1);
        }
        for(int i=0; i<heights[0].length; i++){
            floodFill(heights, pacificFlood, 0, i, -1);
        }
        
        System.out.println(Arrays.toString(atlanticFlood[0]));
        for(int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[0].length; j++){
                if(atlanticFlood[i][j] == -1 && pacificFlood[i][j] == -1){
                    resultantList.add(Arrays.asList(i,j));
                }
            }
        }
        
        return resultantList;
    }
    
    void floodFill(int[][] heights, int[][] target, int i, int j, int val) {
        if(i<0 || i>= target.length || j<0 || j>=target[i].length || target[i][j] == -1){
            return;
        }
        if(heights[i][j] >= val){
            target[i][j] = -1;
            floodFill(heights, target, i+1, j, heights[i][j]);
            floodFill(heights, target, i, j+1, heights[i][j]);
            floodFill(heights, target, i-1, j, heights[i][j]);
            floodFill(heights, target, i, j-1, heights[i][j]);
        }
    }
}