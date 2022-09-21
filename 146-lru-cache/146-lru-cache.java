class LRUCache {
    
    Integer MAX_CAPACITY;
    Map<Integer,Integer> linkMap;

    public LRUCache(int capacity) {
        this.MAX_CAPACITY = capacity;
        linkMap = new LinkedHashMap<>() {
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > MAX_CAPACITY;
            }
        };
    }
    
    public int get(int key) {
        if(linkMap.containsKey(key)){
            int val = linkMap.get(key);
            linkMap.remove(key);
            linkMap.put(key,val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(linkMap.containsKey(key)){
            linkMap.remove(key);
        }
        linkMap.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */