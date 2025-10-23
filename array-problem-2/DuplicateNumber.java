import java.util.*;

public class DuplicateNumber {
    public static void main(String[] args) {
        DuplicateSolution solution = new DuplicateSolution();
        int[] nums = {3,5,6,1,2,2,7};
        int duplicateNum = solution.findDuplicate(nums);
        System.out.println(duplicateNum);
    }
}

class DuplicateSolution {
    public int findDuplicate(int[] nums) {
        // Your code goes here
        Map<Integer,Integer> digiMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(digiMap.getOrDefault(nums[i],0) ==1){
                return nums[i];
            } else{
                digiMap.put(nums[i],1);
            }
        }
        return 0;
    }
}
