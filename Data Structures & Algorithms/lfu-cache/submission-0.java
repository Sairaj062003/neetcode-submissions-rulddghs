public class Node {
    int key;
    int val;
    int use_counter;
    Node prev;
    Node next;

     public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.use_counter=1;
        this.prev = null;
        this.next = null;
     }
}
class LFUCache {
     int cap ;
     private HashMap<Integer, Node> map;
     Node head ;
     Node tail;

    public LFUCache(int capacity) {
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
        node.use_counter += 1;
        delete(node);
        insert(node);
        return node.val; 
    }
    
    public void put(int key, int value) {
         if (cap == 0) return; 

         if(map.containsKey(key)){
             Node newNode = map.get(key);
             newNode.val = value;
             newNode.use_counter += 1;
             delete(newNode);
             insert(newNode);
        }
         else{

            if(map.size() >= cap){
              Node node = this.tail.prev;
              Node node1 = node;
              int counter = node.use_counter;
               
               node = node.prev;
              while(node != head){
                if(counter>node.use_counter){
                    counter = node.use_counter;
                    node1 = node;
                }
                    
                node=node.prev ;
              }
              
              map.remove(node1.key );
              delete(node1);

            }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */