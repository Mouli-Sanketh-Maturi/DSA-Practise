class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int overallProfit = 0;
        for(int i=1;i<prices.length;i++){
            
            if(prices[i] < prices[i-1]){
                overallProfit += (prices[i-1] - buyPrice);
                buyPrice = prices[i];
            } if (i == prices.length-1){
                overallProfit += (prices[i] - buyPrice);
            }
            if(buyPrice > prices[i]){
                buyPrice = prices[i];
            }
        }
        return overallProfit;
    }
}