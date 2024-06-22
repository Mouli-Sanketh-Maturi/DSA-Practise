import java.util.*;

class LRUCache {

    int capacity;
    int currentCapacity;
    Linked<Integer> linkedList;
    Map<Integer, Node<Integer>> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.linkedList = new Linked<Integer>();
        this.hashMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hashMap.containsKey(key)) {
            return -1;
        }
        Node<Integer> node = hashMap.get(key);
        linkedList.delete(node);
        linkedList.insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node<Integer> node = null;
        if(!hashMap.containsKey(key)) {
            currentCapacity++;
            node = new Node<Integer>(key,value);
        } else {
            node = hashMap.get(key);
            linkedList.delete(node);
            node.val = value;
        }
        linkedList.insert(node);
        hashMap.put(key,node);
        if(currentCapacity > capacity) {
            Node<Integer> removedNode = linkedList.removeLast();
            currentCapacity--;
            if(removedNode != null) {
                hashMap.remove(removedNode.key);
            }
        }
    }
}

class Linked<T> {

    Node<T> head;
    Node<T> end;

    public Linked() {
        head = new Node<T>(null,null);
        end = new Node<T>(null,null);
        this.head.next = end;
        this.end.prev = head;
    }

    public void insert(Node<T> node) {
        this.head.next.prev = node;
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
    }

    public void delete(Node<T> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node<T> removeLast() {
        if(this.end.prev != this.head) {
            Node<T> node = this.end.prev;
            this.end.prev.next = null;
            this.end.prev.prev.next = end;
            this.end.prev = this.end.prev.prev;
            return node;
        }
        return null;
    }

}

class Node<T> {
    Node<T> next;
    Node<T> prev;
    T val;
    T key;
    public Node(T key, T val) {
        this(key, val, null, null);
    }
    public Node(T key, T val, Node<T> prev, Node<T> next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */