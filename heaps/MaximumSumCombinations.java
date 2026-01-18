import java.util.*;
public class MaximumSumCombinations {
    public static void main(String[] args) {
        int[] nums1={7,3};
        int[] nums2={1,6};

        int k=2;

        MaximumSumCombinationsSolution solution = new MaximumSumCombinationsSolution();

        int[] result = solution.maxSumCombinations(nums1,nums2,k);
        for (int i:result){
            System.out.print(i+" ");
        }
    }
}


class MaximumSumCombinationsSolution {
    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n= nums1.length;
        for(int i=0;i<n/2;i++){
            int temp =nums1[i];
            nums1[i] = nums1[n-1-i];
            nums1[n-1-i] = temp;

            temp =nums2[i];
            nums2[i] = nums2[n-1-i];
            nums2[n-1-i] = temp;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        Set<String> visited = new HashSet<>();

        pq.add(new int[]{nums1[0]+nums2[0],0,0});
        visited.add("0,0");

        List<Integer> result = new ArrayList<>();

        while(k-- > 0 && !pq.isEmpty()){
            int[] top = pq.poll();
            int sum=top[0], i=top[1], j=top[2];

            result.add(sum);

            if(i+1 < nums1.length && !visited.contains((i+1)+","+j)){
                pq.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                visited.add((i+1)+","+j);
            }

            if(j+1 < nums2.length && !visited.contains(i+","+(j+1))){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                visited.add(i+","+(j+1));
            }
        }

        return result.stream().mapToInt(Integer:: intValue).toArray();
    }
}