func minCostClimbingStairs(cost []int) int {
    length := len(cost)
    if length < 3 {
        return min(cost[0],cost[1])
    }
    
    calcCost := make([]int, length+1)
    
    calcCost[0] = 0
    calcCost[1] = 0
    
    for i:=2; i<=length; i++ {
        calcCost[i] = min(calcCost[i-1] + cost[i-1], calcCost[i-2] + cost[i-2])
    }
    
    return calcCost[length]
}

func min(a int, b int) int {
    if a < b {
        return a
    }
    return b
}