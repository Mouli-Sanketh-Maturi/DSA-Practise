class Solution {
    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        int currentProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<leastSoFar){
                leastSoFar = prices[i];
            }
            currentProfit = prices[i] - leastSoFar;
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}