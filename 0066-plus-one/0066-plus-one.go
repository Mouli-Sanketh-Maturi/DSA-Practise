func plusOne(digits []int) []int {
	idx := len(digits) - 1
	carry := 1
	for ; carry == 1 && idx >= 0; idx-- {
		if digits[idx] == 9 {
			digits[idx] = 0
		} else {
			digits[idx] += carry
			carry = 0
		}
	}

	if carry == 1 {
		return append([]int{1}, digits...)
	}
	return digits
}