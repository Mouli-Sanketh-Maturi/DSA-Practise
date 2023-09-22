class Solution {
    public int maxProfit(int[] prices) {
        int leastPrice = prices[0];
        int maxProfit = 0;
        for(int currPrice : prices) {
            if(currPrice <= leastPrice) {
                leastPrice = currPrice;
            } else {
                int currProfit = currPrice - leastPrice;
                if (currProfit > maxProfit) {
                    maxProfit = currProfit;
                }
            }
        }

        return maxProfit;
    }
}