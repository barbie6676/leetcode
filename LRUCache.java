/*LRU Cache */

public class LRUCache {
    
    static public class Pair {
		int key;
		int val;
		Pair before;
		Pair next;
		public Pair(int k, int v){
			key = k;
			val = v;
			before = null;
			next = null;
		}
	}
    
    //private LinkedList< Pair > item_list ;
    //private ArrayDeque<Pair> item_list;
    private Pair head;
    private Pair tail;
    private HashMap<Integer, Pair > item_map;
    private int cap;
    private int size;
    
    public LRUCache(int capacity) {
        head = new Pair(-1,-1);
        tail = new Pair(-1,-1);
        head.next = tail;
        tail.before = head;
    	item_map = new HashMap<Integer, Pair>();
    	cap = capacity;
    	size = 0;
    }
    
    private void clean(){
        while(size>cap){
            Pair last_it = tail.before;
            remove(last_it);
            item_map.remove(last_it.key);
            size--;
        }
    }
    
    public int get(int key) {
        //assert(exist(key));
        if (!item_map.containsKey(key)) return -1;
        
        Pair it = item_map.get(key);
        if (it != head.next){
       
            remove(it);
            
            addFirst(it);
        }
        return it.val;
    }
    
    public void set(int key, int value) {
        if(item_map.containsKey(key)){
        	Pair it = item_map.get(key);
            //item_list.remove(it);
            remove(it);
            item_map.remove(key);
            size--;
        }
        Pair newNode = new Pair(key,value);
        addFirst(newNode);
        item_map.put(key, head.next);
        size++;
        clean();
    }
    
    private void addFirst(Pair node){
        
        node.next = head.next;
        head.next.before = node;
        head.next = node;
        node.before = head;
    }
    
    private void remove(Pair node){
        
        node.before.next = node.next;
        node.next.before = node.before;
    }
}
