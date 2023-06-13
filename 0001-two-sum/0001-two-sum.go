func twoSum(nums []int, target int) []int {
    
    targetMap := map [int] int { }


    for i, c := range nums {
                
        index, present := targetMap[c]
        
        if present {
            arr := []int {i,index}
            return arr
        }
        
        targetMap[target - c] = i
        
    }
    arr := []int {0,0}
    return arr
}