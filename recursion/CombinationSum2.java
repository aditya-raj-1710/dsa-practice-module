import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2Solution sol = new CombinationSum2Solution();

        // Sample input
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        // Call the combinationSum2 function
        List<List<Integer>> result = sol.combinationSum2(candidates, target);

        // Output the result
        System.out.println("Combinations are: ");
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class CombinationSum2Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);
        int index = 0;

        func(index,target,candidates,curr,ans);

        return ans;
    }

    private void func(int index, int target, int[] candidates, List<Integer> curr, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index == candidates.length){
            return;
        }

        curr.add(candidates[index]);

        func(index+1, target - candidates[index],candidates, curr, ans);

        curr.remove(curr.size()-1);

        for(int i= index+1;i< candidates.length;i++){
            if(candidates[i] != candidates[index]){
                func(i,target,candidates,curr,ans);
                break;
            }
        }
    }
}
