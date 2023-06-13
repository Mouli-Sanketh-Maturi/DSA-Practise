func maxProfit(prices []int) int {
    
    lowestPrice := prices[0]
	maxProfit := 0
	
	for _,p := range prices {
		if p < lowestPrice {
			lowestPrice = p
            continue
		}
        localMaxProfit := p - lowestPrice
        if (localMaxProfit) > maxProfit {
			maxProfit = localMaxProfit
		}
	}

	return maxProfit
    
}