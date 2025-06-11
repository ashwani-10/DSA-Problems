class LRUCache {
    int capacity;
    Map<Integer,Node> map;
    Node head,tail;

    private final class Node {
        int key,val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node nn = map.get(key);
            nn.val = value;
            remove(nn);
            insert(nn);
        }
        else{
                if(map.size() == this.capacity){
                    Node node = tail.prev;
                    remove(node);
                    map.remove(node.key);
                }
            Node nn = new Node(key,value);
            insert(nn);
            map.put(key,nn);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */