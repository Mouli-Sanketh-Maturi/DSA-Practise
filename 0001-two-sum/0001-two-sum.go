func twoSum(nums []int, target int) []int {
    for i, c := range nums {
        for j := i+1; j < len(nums); j++ {
            if c + nums[j] == target {
                arr := []int {i,j}
                return arr
            }
        }
    }
    arr := []int {0,0}
    return arr
}