func combinationSum(candidates []int, target int) [][]int {

	finalCandidates := make([][]int, 0)

	var backtrack func(index, currSum int, currentCandidates []int)

	backtrack = func(index, currSum int, currentCandidates []int) {
		if currSum == target {
			cand := make([]int, len(currentCandidates))
			copy(cand, currentCandidates)
			finalCandidates = append(finalCandidates, cand)
            return
		} else if currSum > target || index >= len(candidates) {
			return
		}

		backtrack(index+1, currSum, currentCandidates)
		backtrack(index, currSum+candidates[index], append(currentCandidates, candidates[index]))
	}

	backtrack(0, 0, []int{})

	return finalCandidates
}