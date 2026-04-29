import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        PowerSetSolution sol = new PowerSetSolution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = sol.powerSet(nums);

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}

class PowerSetSolution {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,nums.length,nums,new ArrayList<>(),ans);
        return ans;
    }

    private void backtrack(int ind, int n, int[] nums, List<Integer> current, List<List<Integer>> ans){
        if(ind == n){
            ans.add(new ArrayList<>(current));
            return;
        }

        // not take scenario
        backtrack(ind+1,n,nums,current,ans);

        //take scenario
        current.add(nums[ind]);
        backtrack(ind+1,n,nums,current,ans);
        current.remove(current.size()-1);

        // take and not take recursive call can be interchanged and output remains same.
    }
}