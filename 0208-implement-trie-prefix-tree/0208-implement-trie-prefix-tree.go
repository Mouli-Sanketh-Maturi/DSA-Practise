type Trie struct {
	children map[rune]*Trie
	end      bool
}

func Constructor() Trie {
	return Trie{make(map[rune]*Trie), false}
}

func (this *Trie) Insert(word string) {
	ptr := this
	for _, s := range word {
		if child, exists := ptr.children[s]; exists {
			ptr = child
		} else {
			newChild := Constructor()
			ptr.children[s] = &newChild
			ptr = &newChild
		}
	}
	ptr.end = true
}

func (this *Trie) Search(word string) bool {
	ptr := this
	for _, s := range word {
		if child, exists := ptr.children[s]; exists {
			ptr = child
		} else {
			return false
		}
	}
	return ptr.end
}

func (this *Trie) StartsWith(prefix string) bool {
	ptr := this
	for _, s := range prefix {
		if child, exists := ptr.children[s]; exists {
			ptr = child
		} else {
			return false
		}
	}
	return true
}
