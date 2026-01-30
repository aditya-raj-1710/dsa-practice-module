import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximumSolution solution = new SlidingWindowMaximumSolution();
        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k=3;

        int[] result=solution.maxSlidingWindow(arr,k);
        for (int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class SlidingWindowMaximumSolution {
    /// optimal approach
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n-k+1];
        int resultInd=0;

        Deque<Integer> dq = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst() <=(i-k)){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=(k-1)){
                result[resultInd++] = arr[dq.peekFirst()];
            }
        }
        return result;
    }


    /// Brute Force
    public int[] maxSlidingWindowBrute(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=arr.length-k;i++){
            int maxi = arr[i];
            for (int j=i;j<i+k;j++){
                maxi = Math.max(maxi,arr[j]);
            }
            result.add(maxi);
        }
        //System.out.println(result);
        return result.stream().mapToInt(Integer ::intValue).toArray();
    }
}

