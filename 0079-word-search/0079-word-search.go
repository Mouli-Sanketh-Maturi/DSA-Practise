func exist(board [][]byte, word string) bool {
	columnLen := len(board)
	rowLen := len(board[0])
	for i := 0; i < columnLen; i++ {
		for j := 0; j < rowLen; j++ {
			if checkIfExists(board, word, i, j, 0, columnLen-1, rowLen-1, len(word)-1) {
				return true
			}
		}
	}
	return false
}

func checkIfExists(board [][]byte, word string, i, j, k, maxI, maxJ, maxK int) bool {
	if k > maxK {
		return true
	}
	if i < 0 || i > maxI || j < 0 || j > maxJ {
		return false
	}
	if board[i][j] == word[k] {
		board[i][j] = 1
		value := checkIfExists(board, word, i+1, j, k+1, maxI, maxJ, maxK) || checkIfExists(board, word, i-1, j, k+1, maxI, maxJ, maxK) ||
			checkIfExists(board, word, i, j+1, k+1, maxI, maxJ, maxK) || checkIfExists(board, word, i, j-1, k+1, maxI, maxJ, maxK)
			board[i][j] = word[k]
			return value
	}
	return false
}