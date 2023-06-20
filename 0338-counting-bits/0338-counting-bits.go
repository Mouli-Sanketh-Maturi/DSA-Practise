func countBits(n int) []int {

	/* 19 - 10011 - Number of bits in 1001 + last bit
	   So, 19 >> 1 + last bit */

	count := make([]int, n+1)

	for i, _ := range count {
		count[i] = count[i>>1] + (i & 1)
	}

	return count
}
