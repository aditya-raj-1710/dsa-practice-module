import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        Subsets2Solution sol = new Subsets2Solution();
        int[] nums = {1, 2, 2};  // Example input
        List<List<Integer>> result = sol.subsetsWithDup(nums);

        // Print the resulting subsets
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}

class Subsets2Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        Arrays.sort(nums);

        func(0,arr,ans,nums);
        return ans;
    }

    private void func(int index, List<Integer> arr, List<List<Integer>> ans, int[] nums){
        if(index == nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[index]);

        func(index+1, arr, ans, nums);

        arr.remove(arr.size()-1);

        for(int i=index+1; i < nums.length;i++){
            if(nums[i] != nums[index]){
                func(i,arr,ans,nums);
                return;
            }
        }

        func(nums.length,arr,ans,nums);
    }
}