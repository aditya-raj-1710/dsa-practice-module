import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        MergeKSortedArraysSolution solution = new MergeKSortedArraysSolution();
        int[][] arr = {
                {1, 5, 9},
                {2, 6, 10},
                {3, 7, 11}
        };
        int k = 3;

        List<Integer> res = solution.mergeKSortedArrays(arr, k);

        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println(); // Output: 1 2 3 5 6 7 9 10 1
    }
}

class MergeKSortedArraysSolution {
    public List<Integer> mergeKSortedArrays(int[][] arr, int k) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(int i=0;i<k;i++){
            pq.add(new int[]{arr[i][0],i,0});
        }

        while(!pq.isEmpty()){
            int[] touple = pq.poll();
            int val = touple[0], row=touple[1],i=touple[2];

            result.add(val);

            if(i+1 < k ){
                pq.add(new int[]{arr[row][i+1],row,i+1});
            }
        }
        return result;
    }
}