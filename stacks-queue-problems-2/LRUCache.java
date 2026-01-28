import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCacheSolution cache = new LRUCacheSolution(2);

        // Queries
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }
}

/// LRU Implementation
class LRUCacheSolution {
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;
    private int capacity;

    public LRUCacheSolution(int capacity) {
        this.capacity=capacity;
        head = new Node();
        tail = new Node();
        map = new HashMap<>();

        head.previous=null;
        tail.next=null;

        head.next=tail;
        tail.previous=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node currNode = map.get(key);
            int value = currNode.value;
            deleteNode(currNode);
            insertAfterHead(currNode);
            return value;
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curNode = map.get(key);
            curNode.value = value;

            deleteNode(curNode);
            insertAfterHead(curNode);
            return;
        }

        if(map.size() == capacity){
            Node lastNode = tail.previous;
            map.remove(lastNode.key);
            deleteNode(lastNode);
        }

        Node newNode = new Node(key,value);
        insertAfterHead(newNode);
        map.put(key,newNode);


    }

    private void deleteNode(Node node){
        Node previousNode = node.previous;
        previousNode.next = node.next;
        node.next.previous = previousNode;
    }

    private void insertAfterHead(Node node){
        node.next = head.next;
        node.previous = head;
        head.next.previous =node;
        head.next=node;
    }

}

/// Node Class
class Node{
    int value;
    int key;
    int cnt;
    Node previous;
    Node next;

    Node(){
        this.value=-1;
        this.next=null;
        this.previous=null;
    }

    Node(int key, int value){
        this.key = key;
        this.value=value;
        this.cnt=1;
        this.next=null;
        this.previous=null;
    }
}