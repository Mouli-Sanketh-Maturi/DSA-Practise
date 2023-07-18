func eraseOverlapIntervals(intervals [][]int) int {

	size := len(intervals)
	count := 0
	

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	prevExpiry := intervals[0][1]

	for i := 1; i < size; i++ {
		if prevExpiry > intervals[i][0] {
			count++
			prevExpiry = min(prevExpiry, intervals[i][1])
		} else {
			prevExpiry = intervals[i][1]
		}
	}

	return count

}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}