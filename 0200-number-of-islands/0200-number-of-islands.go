func numIslands(grid [][]byte) int {
    count := int(0)
	for i, _ := range grid {
		for j, val := range grid[i] {
			if val == '1' {
				floodFill(grid, i, j)
				count = count + 1
			}
		}
	}
	return count
}

func floodFill(grid [][]byte, i, j int) {
	if i < 0 || i >= len(grid) {
		return
	} else if j < 0 || j >= len(grid[i]) {
		return
	}
	if grid[i][j] == '1' {
		grid[i][j] = '2'
		floodFill(grid, i+1, j)
		floodFill(grid, i, j+1)
		floodFill(grid, i-1, j)
		floodFill(grid, i, j-1)
	}
	return
}
