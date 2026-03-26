import java.util.PriorityQueue;

public class KthLargestInStream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1, 2, 3, 4};

        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println("Kth Largest element after adding 5 is: " + kthLargest.add(5));
        System.out.println("Kth Largest element after adding 2 is: " + kthLargest.add(2));
        System.out.println("Kth Largest element after adding 7 is: " + kthLargest.add(7));
    }
}

class KthLargest {
    private int K;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.K = k;
        pq = new PriorityQueue<>();

        for(int num: nums){
            if(pq.size() < K){
                pq.offer(num);
            }else if(pq.peek() < num){
                pq.poll();
                pq.offer(num);
            }
        }
    }

    public int add(int val) {
        if(pq.size()< K){
            pq.offer(val);
            return pq.peek();
        }
        if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
