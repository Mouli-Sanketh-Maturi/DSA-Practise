func maxSubArray(nums []int) int {

	size := len(nums)

	maxSum := nums[0]
	currentSum := 0

	for i := 0; i < size; i++ {
		currentSum += nums[i]
		if currentSum > maxSum {
			maxSum = currentSum
		}
		if currentSum < 0 {
			currentSum = 0
		}
	}

	return maxSum

}