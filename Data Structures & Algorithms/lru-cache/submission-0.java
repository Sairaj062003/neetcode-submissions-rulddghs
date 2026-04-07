public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {

     int cap ;
     private HashMap<Integer, Node> map;
     Node head ;
     Node tail;


    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev= this.head;

        
    }

    private  void delete(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next=nxt;
        nxt.prev=prev;

    }

      private void insert(Node node){
        Node next = this.head.next;
        this.head.next = node;
        node.prev=this.head;
        node.next = next;
        next.prev=node;



      }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        delete(node);
        insert(node);
        return node.val;        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
             Node newNode = map.get(key);
             newNode.val = value;
             delete(newNode);
             insert(newNode);
        }
        else{

            if(map.size() >= cap){
              Node node = this.tail.prev;
              map.remove(node.key);
              delete(node);

            }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        }
        
    }
}
