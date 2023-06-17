func isValid(s string) bool {

	reverseMap := make(map[rune]rune)
	reverseMap['{'] = '}'
	reverseMap['('] = ')'
	reverseMap['['] = ']'

	stack := []rune{}
	ptr := -1

	for _, char := range s {
		reverseChar, exists := reverseMap[char]
		if exists {
			stack = append(stack, reverseChar)
			ptr++
		} else if (ptr > -1) && (stack[ptr] == char) {
            stack = stack[:ptr]
			ptr--
		} else {
			return false
		}
	}

	if ptr == -1 {
		return true
	} else {
		return false
	}
}