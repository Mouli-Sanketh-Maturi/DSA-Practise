func maxProfit(prices []int) int {
    
    lowestPrice := prices[0]
	maxProfit := 0
	
	for _,p := range prices {
		if p < lowestPrice {
			lowestPrice = p
		} else if (p - lowestPrice) > maxProfit {
			maxProfit = p - lowestPrice
		}
	}

	return maxProfit
    
}