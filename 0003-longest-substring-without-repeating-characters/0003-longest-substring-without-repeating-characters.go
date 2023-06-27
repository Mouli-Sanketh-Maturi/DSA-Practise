func lengthOfLongestSubstring(s string) int {

	charMap := make(map[rune]int)
	maxLength := 0
	indxStart := 0

	for index, char := range s {

		prevIndex := charMap[char] - 1

		if prevIndex >= 0 && prevIndex >= indxStart {
			indxStart = prevIndex + 1
		}

		charMap[char] = index + 1

		length := index - indxStart + 1
		if length > maxLength {
			maxLength = length
		}
	}

	return maxLength
}
