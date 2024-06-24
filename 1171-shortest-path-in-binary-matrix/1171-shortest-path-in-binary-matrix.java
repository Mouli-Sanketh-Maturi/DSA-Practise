class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> toBeVisited = new ArrayDeque<>();
        toBeVisited.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!toBeVisited.isEmpty()) {
            int[] entry = toBeVisited.poll();
            if(entry[0] == grid.length-1 && entry[1] == grid[0].length-1) {
                return entry[2];
            }
            if(grid[entry[0]][entry[1]] == 1) {
                continue;
            }
            List<int[]> neighbors = getNeighbors(entry[0], entry[1], grid);
            for(int[] neighbor : neighbors) {
                if(!visited[neighbor[0]][neighbor[1]]) {
                    toBeVisited.add(new int[]{neighbor[0], neighbor[1], entry[2]+1});
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
        }
        return -1;
    }

    public List<int[]> getNeighbors(int x, int y, int[][] grid) {
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1,-1}, {-1,1}, {1,-1}};
        List<int[]> result = new ArrayList<>();

        for(int[] direction : directions) {
            int a = x + direction[0];
            int b = y + direction[1];

            if(a < 0 || a >= grid.length || b < 0 || b >= grid[0].length) {
                
            } else {
                result.add(new int[]{a,b});
            }
        }

        return result;
    }
}