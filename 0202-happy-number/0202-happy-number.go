func isHappy(n int) bool {

	happySet := make(map[int]int)

	num := n

	for {
		if _, exists := happySet[num]; !exists {
			temp := num
			squareSum := 0
			for temp != 0 {
				squareSum += (temp % 10) * (temp % 10)
				temp = temp / 10
			}
			if squareSum == 1 {
				return true
			}
			happySet[num] = 1
			num = squareSum
		} else {
			return false
		}
	}
}