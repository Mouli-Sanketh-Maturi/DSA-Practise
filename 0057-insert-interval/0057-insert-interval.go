func insert(intervals [][]int, newInterval []int) [][]int {
	modifiedIntervals := make([][]int, 0)

	for i, arr := range intervals {
		if arr[1] < newInterval[0] {
			modifiedIntervals = append(modifiedIntervals, arr)
		} else if arr[0] > newInterval[1] {
			modifiedIntervals = append(modifiedIntervals, newInterval)
			modifiedIntervals = append(modifiedIntervals, intervals[i:]...)
			return modifiedIntervals
		} else {
			newInterval[0] = min(arr[0], newInterval[0])
			newInterval[1] = max(arr[1], newInterval[1])
		}
	}
	modifiedIntervals = append(modifiedIntervals, newInterval)
	return modifiedIntervals
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
