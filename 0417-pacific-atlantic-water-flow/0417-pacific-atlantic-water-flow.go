func pacificAtlantic(heights [][]int) [][]int {

	m := len(heights)
	n := len(heights[0])

	pacific := make([][]int,m)
	atlantic := make([][]int,m)

	for i:=range pacific {
		pacific[i] = make([]int,n)
	}
	for i:=range atlantic {
		atlantic[i] = make([]int,n)
	}

	for i := 0; i < m; i++ {
		floodFill(-1, i, 0, m, n, heights, pacific)
	}
	for i := 0; i < n; i++ {
		floodFill(-1, 0, i, m, n, heights, pacific)
	}

	for j := 0; j < m; j++ {
		floodFill(-1, j, n-1, m, n, heights, atlantic)
	}
	for j := 0; j < n; j++ {
		floodFill(-1, m-1, j, m, n, heights, atlantic)
	}

	fmt.Println(pacific)

	fmt.Println(atlantic)

	result := make([][]int, 0)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if pacific[i][j] == -1 && atlantic[i][j] == -1 {
				result = append(result, []int{i, j})
			}
		}
	}

	return result
}

func floodFill(height, i, j, m, n int, heights, ocean [][]int) {
	if i < m && j < n && i >= 0 && j >= 0 {
		if heights[i][j] >= height {
			if ocean[i][j] != -1 {
				ocean[i][j] = -1
				floodFill(heights[i][j], i+1, j, m, n, heights, ocean)
				floodFill(heights[i][j], i-1, j, m, n, heights, ocean)
				floodFill(heights[i][j], i, j+1, m, n, heights, ocean)
				floodFill(heights[i][j], i, j-1, m, n, heights, ocean)
			} 
		}
	}
}