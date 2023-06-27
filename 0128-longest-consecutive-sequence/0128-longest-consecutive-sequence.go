func longestConsecutive(nums []int) int {

	posMap := make(map[int]bool)
	maxLength := 0

	for _, num := range nums {
		posMap[num] = true
	}

	for _,num := range nums {
		if !posMap[num-1] {
			length := 1
			check := num+1
			for posMap[check] == true {
				check++
				length++
			}
			if length > maxLength {
				maxLength = length
			}
		}
	}

	return maxLength
}