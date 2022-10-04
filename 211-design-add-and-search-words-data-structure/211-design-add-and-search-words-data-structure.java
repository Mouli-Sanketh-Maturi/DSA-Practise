class WordDictionary {
    
    Node head;

    public WordDictionary() {
        head = new Node('*', false);
    }
    
    public void addWord(String word) {
        char[] wordChars = word.toCharArray();
        Node ptr = head;
        for(Character c : wordChars) {
            if(ptr.getCharNode(c) == null) {
                ptr.setCharNode(c, new Node(c, false));
            }
            ptr = ptr.getCharNode(c);
        }
        ptr.isEnd = true;
    }
    
    public boolean search(String word) {
        char[] wordChars = word.toCharArray();
        return search(wordChars, 0, head);
    }
    
    private boolean search(char[] wordChars, int index, Node ptr) {
        if(index == wordChars.length)
            return ptr.isEnd;
        if(ptr == null || index > wordChars.length){
            return false;
        }
        if(wordChars[index] == '.') {
            for(Node childPtr : ptr.charMap.values()){
                if(search(wordChars, index+1, childPtr)){
                    return true;
                }
            }
            return false;
        }
        else {
            if(ptr.getCharNode(wordChars[index]) != null){
                return search(wordChars, index+1, ptr.getCharNode(wordChars[index]));
            }
        }
        return false;
    }
}

class Node {
    Character c;
    Boolean isEnd;
    Map<Character,Node> charMap;
    
    public Node(Character c, Boolean isEnd) {
        this.c = c;
        this.isEnd = isEnd;
        this.charMap = new HashMap<>();
    }
    
    public Node getCharNode(Character c) {
        return charMap.get(c);
    }
    
    public void setCharNode(Character c, Node n) {
        charMap.put(c,n);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */