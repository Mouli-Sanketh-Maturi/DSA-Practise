func merge(intervals [][]int) [][]int {

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	newInterval := intervals[0]

	mergedInterval := [][]int{}

	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] <= newInterval[1] {
			newInterval[0] = min(newInterval[0], intervals[i][0])
			newInterval[1] = max(newInterval[1], intervals[i][1])
		} else {
			mergedInterval = append(mergedInterval, newInterval)
			newInterval = intervals[i]
		}
	}

	mergedInterval = append(mergedInterval, newInterval)
	return mergedInterval
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