import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSumSolution sol = new CombinationSumSolution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = sol.combinationSum(candidates, target);
        System.out.println(result);
    }
}

class CombinationSumSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        List<Integer> candidateList = new ArrayList<>();
        for(int i: candidates){
            candidateList.add(i);
        }

        func(candidateList,candidateList.size()-1,target,curr,ans);

        return ans;
    }

    private void func(List<Integer> candidateList, int index, int target, List<Integer> curr, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(target <0 || index <0){
            return;
        }

        func(candidateList,index-1,target,curr,ans);

        curr.add(candidateList.get(index));

        func(candidateList,index,target-candidateList.get(index),curr,ans);

        curr.remove(curr.size()-1);
    }
}
