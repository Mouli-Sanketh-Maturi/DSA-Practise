func search(nums []int, target int) int {
    return searchBinary(nums, target, 0, len(nums)-1)
}

func searchBinary(nums []int, target int, low int, high int) int {
    if low > high {
        return -1
    }
    
    mid := low + (high - low)/2
    
    if target == nums[mid] {
        return mid
    } else if target < nums[mid] {
        return searchBinary(nums, target, low, mid-1)
    } else {
        return searchBinary(nums, target, mid+1, high)
    }
}