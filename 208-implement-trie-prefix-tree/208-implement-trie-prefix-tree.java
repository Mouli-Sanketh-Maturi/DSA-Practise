class Trie {

    Node head = null;

    public Trie() {
        this.head = new Node('*', false);
    }
    
    public void insert(String word) {
        char[] wordChars = word.toCharArray();
        Node ptr = head;
        for(char c: wordChars){
            if(ptr.getCharAddr(c) == null){
                ptr.putCharAddr(c, new Node(c,false));
            }
            ptr = ptr.getCharAddr(c);
        }
        ptr.isEnd = true;
    }
    
    public boolean search(String word) {
        char[] wordChars = word.toCharArray();
        Node ptr = head;
        for(char c: wordChars){
            if(ptr.getCharAddr(c) != null){
                ptr = ptr.getCharAddr(c);
            } else {
                return false;
            }
        }
        if(ptr.isEnd == true){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        char[] wordChars = prefix.toCharArray();
        Node ptr = head;
        for(char c: wordChars){
            if(ptr.getCharAddr(c) != null){
                ptr = ptr.getCharAddr(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

class Node {
    Character c;
    Boolean isEnd;
    Map<Character,Node> charMap;

    public Node(Character c, Boolean isEnd){
        this.c = c;
        this.isEnd = isEnd;
        this.charMap = new HashMap<>();
    }

    public Node getCharAddr(Character c){
        return charMap.get(c);
    }

    public void putCharAddr(Character c, Node n){
        charMap.put(c,n);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */