type WordDictionary struct {
	nextMap map[rune]*WordDictionary
	end     bool
}

func Constructor() WordDictionary {
	return WordDictionary{make(map[rune]*WordDictionary), false}
}

func (this *WordDictionary) AddWord(word string) {
	ptr := this
	for _, runes := range word {
		if nextPtr, exists := ptr.nextMap[runes]; exists {
			ptr = nextPtr
		} else {
			next := Constructor()
			ptr.nextMap[runes] = &next
			ptr = &next
		}
	}
	ptr.end = true
}

func (this *WordDictionary) Search(word string) bool {
	ptr := this
	for idx, runes := range word {
		if runes == '.' {
			exists := false
			for _, nextPtr := range ptr.nextMap {
				exists = nextPtr.Search(word[idx+1:]) || exists
			}
			return exists
		} else {
			if nextPtr, exists := ptr.nextMap[runes]; exists {
				ptr = nextPtr
			} else {
				return false
			}
		}
	}
	return ptr.end
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddWord(word);
 * param_2 := obj.Search(word);
 */