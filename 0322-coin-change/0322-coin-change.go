
func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	dp[0] = 0

	for i := 1; i <= amount; i++ {
		dp[i] = amount+1
	}

	for amt := 1; amt <= amount; amt++ {
		for _,coin := range coins {
			if amt >= coin {
				dp[amt] = min(dp[amt], 1+dp[amt-coin])
			}
		}
	}

	if dp[amount] == amount+1 {
		return -1
	}
	return dp[amount]
}


func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
