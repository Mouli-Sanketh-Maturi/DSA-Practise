class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return floodFill(image,sr,sc,color,image[sr][sc]);
    }
    
    public int[][] floodFill(int [][] image, int sr, int sc, int color, int startColor){
        if(sr >= image.length || sr<0){
            return image;
        } else if(sc >= image[0].length || sc<0){
            return image;
        }
        if(image[sr][sc] == color){
            return image;
        }
        if(image[sr][sc] == startColor){
            image[sr][sc] = color;
            floodFill(image,sr+1,sc,color,startColor);
            floodFill(image,sr-1,sc,color,startColor);
            floodFill(image,sr,sc+1,color,startColor);
            floodFill(image,sr,sc-1,color,startColor);
        }
        return image;
    }
}