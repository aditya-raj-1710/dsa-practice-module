import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;
        int[] result = solution.twoSum(nums,target);
        System.out.println("Indexes of the two elements: "+ result[0]+", "+result[1]);
    }
}

class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> result = new HashMap<>();
        for(int i =0; i< nums.length;i++){
            int num = nums[i];
            int secondNum = target - num;

            if(result.containsKey(secondNum)){
                return new int[]{result.get(secondNum),i};
            }
            result.put(num,i);
        }
        return new int[]{-1,-1};
    }
}