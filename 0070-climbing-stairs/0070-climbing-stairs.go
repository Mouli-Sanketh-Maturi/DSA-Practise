func climbStairs(n int) int {

    if n == 1 {
        return 1
    } else if n == 2 {
        return 2
    }
	possibilities := make([]int, n+1)
	possibilities[1] = 1
	possibilities[2] = 2

	for i := 3; i <= n; i++ {
		possibilities[i] = possibilities[i-1] + possibilities[i-2]
	}

	return possibilities[n]
}