func maxArea(height []int) int {
	maxArea := 0
	i := 0
	j := len(height) - 1

	for i < j {
		if height[i] > height[j] {
			area := (j - i) * (height[j])
			if area > maxArea {
				maxArea = area
			}
			j--
		} else {
			area := (j - i) * (height[i])
			if area > maxArea {
				maxArea = area
			}
			i++
		}
	}

	return maxArea
}
