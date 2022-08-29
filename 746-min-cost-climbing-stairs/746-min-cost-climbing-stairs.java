class Solution {
    Map<Integer,Integer> minCostMap = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        calculateMinCost(cost,0);
        if(minCostMap.get(1) > minCostMap.get(0)){
            return minCostMap.get(0);
        }
        return minCostMap.get(1);
    }
    
    int calculateMinCost(int[] cost,int i){
        if(i >= cost.length){
            return 0;
        }
        if(minCostMap.containsKey(i)){
            return minCostMap.get(i);
        }
        int sol1 = cost[i] + calculateMinCost(cost,i+1);
        int sol2 = cost[i] + calculateMinCost(cost,i+2);
        if(sol1>sol2){
            minCostMap.put(i,sol2);
            return sol2;
        } else {
            minCostMap.put(i,sol1);
            return sol1;
        }
    }
}