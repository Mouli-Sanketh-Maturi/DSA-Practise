type frequencies struct {
	Num, Freq int
}

func topKFrequent(nums []int, k int) []int {
	frequencyMap := make(map[int]int)

	for _, num := range nums {
		frequencyMap[num] += 1
	}

	frequencyArray := []frequencies{}

	for key, value := range frequencyMap {
		frequencyArray = append(frequencyArray, frequencies{key, value})
	}

	sort.Slice(frequencyArray, func(i, j int) bool {
		return frequencyArray[i].Freq > frequencyArray[j].Freq
	})

	kelements := []int{}
	for i := 0; i < k; i++ {
		kelements = append(kelements, frequencyArray[i].Num)
	}

	return kelements
}