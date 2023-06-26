func groupAnagrams(strs []string) [][]string {

	var freqMap = make(map[string][]string)

	for _, str := range strs {

		var freq [26]int

		for _, chars := range str {
			freq[chars-'a']++
		}

		freqMap[fmt.Sprint(freq)] = append(freqMap[fmt.Sprint(freq)], str)
	}

	var res = make([][]string, 0)

	for _, val := range freqMap {
		res = append(res, val)
	}

	return res
}