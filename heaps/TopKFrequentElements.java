import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-2,-2,-2,-3,-3};
        int k=2;
        TopKFrequentElementsSolution solution = new TopKFrequentElementsSolution();
        var result = solution.topKFrequent(nums,k);

        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
        result = solution.topKFrequentUsingList(nums,k);

        for(int i: result){
            System.out.print(i+" ");
        }
    }
}

class TopKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        System.out.println(freq.toString());

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry:: getValue));

        for(Map.Entry<Integer,Integer> element: freq.entrySet()){
            pq.add(element);

            if(pq.size() >k){
                pq.poll();
            }
        }
        System.out.println(pq.toString());

        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> element = pq.poll();
            result[i++] = element.getKey();
        }

        return result;
    }

    public int[] topKFrequentUsingList(int[] nums,int k){
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        System.out.println(freq);
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a,b)-> b.getValue()-a.getValue());
        System.out.println(list);

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = list.get(i).getKey();
        }
        return result;

    }
}