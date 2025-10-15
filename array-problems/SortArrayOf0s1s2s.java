import java.util.HashMap;
import java.util.Map;

public class SortArrayOf0s1s2s {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,0,2,1,2,0,2,1};
        solution.printArray(nums);
        solution.sortZeroOneTwo(nums);
        solution.printArray(nums);
    }
}
class Solution {
    public void sortZeroOneTwo(int[] nums) {
        Map<Integer,Integer> keyCount = new HashMap<>();
        for(int i: nums){
            keyCount.put(i, keyCount.getOrDefault(i,0)+1);
        }
        int i=0;
        for(Map.Entry<Integer,Integer> pair: keyCount.entrySet()){
            int count = pair.getValue();
            int key = pair.getKey();
            while(count >0){
                nums[i] = key;
                i++;
                count--;
            }
        }

    }

    public void printArray(int[] nums){
        for(int i : nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}