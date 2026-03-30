import java.util.PriorityQueue;

public class KthLargestInArray {
    public static void main(String[] args) {
        int[] nums = {-5, 4, 1, 2, -3};
        int k = 5;

        KthLargestInArraySolution sol = new KthLargestInArraySolution();

        int ans = sol.kthLargestElement(nums, k);

        System.out.println("The Kth largest element in the array is: " + ans);
    }
}

class KthLargestInArraySolution {
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n= nums.length;

        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }

        for(int i=k;i<n;i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}
