func missingNumber(nums []int) int {

	xor := len(nums)
	for i, j := range nums {
		xor = xor ^ i ^ j
	}

	return xor
}