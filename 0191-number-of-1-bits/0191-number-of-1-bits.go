func hammingWeight(num uint32) int {

	temp := uint32(1)
	count := 0

	for temp != 0 {
		if temp&num != 0 {
			count++
		}
		temp = temp << 1
	}

	return count
}