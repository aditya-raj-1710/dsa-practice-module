import java.util.*;

public class SubArrayDistinctCount {
    public static void main(String[] args) {
        SubArrayDistinctCountSolution sol = new SubArrayDistinctCountSolution();
        int[] nums = {1, 2, 1, 3, 4, 3, 5};
        int k = 3;

        List<Integer> result = sol.distinctNumbers(nums, k);

        for (int count : result) {
            System.out.print(count + " ");
        }
        System.out.println();

        List<Integer> result2 = sol.distinctNumbersBrute(nums, k);

        for (int count : result2) {
            System.out.print(count + " ");
        }
    }
}

class SubArrayDistinctCountSolution {
    public List<Integer> distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        result.add(freq.size());

        for(int i=k;i<n;i++){
            int outGoing = nums[i-k];
            freq.put(outGoing, freq.getOrDefault(outGoing,1)-1);
            if(freq.get(outGoing) == 0){
                freq.remove(outGoing);
            }
            int inComing = nums[i];
            freq.put(inComing, freq.getOrDefault(inComing,0)+1);
            result.add(freq.size());
        }

        return result;
    }

    public List<Integer> distinctNumbersBrute(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i=0; i <= n-k;i++){
            Set<Integer> set = new HashSet<>();
            for(int j= i ; j< i+k;j++){
                set.add(nums[j]);
            }
            result.add(set.size());
        }
        return result;
    }

}

