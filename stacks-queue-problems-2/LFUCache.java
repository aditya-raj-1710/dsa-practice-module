import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    public static void main(String[] args) {
        LFUCacheSolution cache = new LFUCacheSolution(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        System.out.print(cache.get(3) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }
}

/// LRU Implementation
class LFUCacheSolution {
    private Map<Integer,Node> keyNode;
    private Map<Integer,ListN> freqListNMap;
    private int capacity;
    private int minFreq;
    private int currSize;

    public LFUCacheSolution(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        currSize = 0;
        keyNode = new HashMap<>();
        freqListNMap = new HashMap<>();
    }

    private void updateFreqListNMap(Node node) {
        keyNode.remove(node.key);

        freqListNMap.get(node.cnt).removeNode(node);

        if (node.cnt == minFreq &&
                freqListNMap.get(node.cnt).size == 0) {
            minFreq++;
        }

        ListN nextHigherFreqListN = new ListN();

        if (freqListNMap.containsKey(node.cnt + 1)) {
            nextHigherFreqListN =
                    freqListNMap.get(node.cnt + 1);
        }

        node.cnt += 1;

        nextHigherFreqListN.addFront(node);

        freqListNMap.put(node.cnt, nextHigherFreqListN);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            int val = node.value;
            updateFreqListNMap(node);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListNMap(node);
        } else {
            if (currSize == capacity) {
                ListN ListN = freqListNMap.get(minFreq);
                keyNode.remove(ListN.tail.previous.key);

                freqListNMap.get(minFreq).removeNode(ListN.tail.previous);
                currSize--;
            }
            currSize++;

            minFreq = 1;

            ListN ListNFreq = new ListN();

            if (freqListNMap.containsKey(minFreq)) {
                ListNFreq = freqListNMap.get(minFreq);
            }

            Node node = new Node(key, value);

            ListNFreq.addFront(node);
            keyNode.put(key, node);
            freqListNMap.put(minFreq, ListNFreq);
        }
    }

}

class ListN{
    int size;
    Node head;
    Node tail;

    ListN() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
        size = 0;
    }

    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.previous = head;
        head.next = node;
        temp.previous = node;
        size++;
    }

    void removeNode(Node delnode) {
        Node prevNode = delnode.previous;
        Node nextNode = delnode.next;
        prevNode.next = nextNode;
        nextNode.previous = prevNode;
        size--;
    }
}