func productExceptSelf(nums []int) []int {

	length := len(nums)
	leftProduct := make([]int, length)
	rightProduct := make([]int, length)
	product := make([]int, length)

	leftProduct[0] = nums[0]
	rightProduct[length-1] = nums[length-1]

	for i := 1; i < length-1; i++ {
		leftProduct[i] = leftProduct[i-1] * nums[i]
		rightProduct[length-i-1] = rightProduct[length-i] * nums[length-i-1]
	}

	for i := 1; i < length-1; i++ {
		product[i] = leftProduct[i-1] * rightProduct[i+1]
	}

	product[0] = rightProduct[1]
	product[length-1] = leftProduct[length-2]

	return product
}