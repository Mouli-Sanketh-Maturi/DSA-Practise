class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> orangeQueue = new LinkedList<>();
        int minutes = 0;
        int[][] nextCoordinates = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    orangeQueue.add(new int[]{i,j});
                }
            }
        }

        orangeQueue.add(new int[]{-1,-1});

        while(!orangeQueue.isEmpty()) {
            int[] coord = orangeQueue.poll();
            int x = coord[0];
            int y = coord[1];
            if(x == -1 && y == -1) {
                if(!orangeQueue.isEmpty()) {
                    orangeQueue.add(coord);
                    minutes++;
                }
            } else if(isRot(x, y, grid)) {
                for(int[] nextCoordinate : nextCoordinates) {
                    if(canRot(x+nextCoordinate[0],y+nextCoordinate[1],grid))
                        orangeQueue.add(new int[]{x+nextCoordinate[0], y+nextCoordinate[1]});
                }
            }
        }

        for(int[] temp : grid) {
            for(int temps : temp) {
                if(temps == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }

    public Boolean isRot(int x, int y, int[][] grid) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if(grid[x][y] == 2) {
            return true;
        }
        return false;
    }

    public Boolean canRot(int x, int y, int[][] grid) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if(grid[x][y] == 1) {
            grid[x][y] = 2;
            return true;
        }
        return false;
    }
}