import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArrayPermutation {
    public static void main(String[] args) {
        // Create solution object
        StringArrayPermutationSolution sol = new StringArrayPermutationSolution();

        // Test 1
        System.out.println(sol.permuteUnique("abc"));
        // Test 2
        System.out.println(sol.permuteUnique("aab"));
        int[] input = {1,2,3};

        System.out.println(sol.permute(input));
        //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
}

class StringArrayPermutationSolution {

    /// String permutation
    public List<String> permuteUnique(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        boolean[] used = new boolean[arr.length];

        backtrack(arr,used,path,result);

        return result;
    }

    private void backtrack(char[] arr, boolean[] used, StringBuilder path, List<String> result){
        if(path.length() == arr.length){
            result.add(path.toString());
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(used[i]){
                continue;
            }

            if(i>0 && arr[i] == arr[i-1] && !used[i-1]){
                continue;
            }

            used[i] = true;
            path.append(arr[i]);

            backtrack(arr,used,path,result);

            path.deleteCharAt(path.length()-1);
            used[i] = false;

        }
    }

    /// Array Permutation
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums,used,path,result);

        return result;
    }

    private void backtrack(int[] arr, boolean[] used, List<Integer> path, List<List<Integer>> result){
        if(path.size() == arr.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(used[i]){
                continue;
            }

            if(i>0 && arr[i] == arr[i-1] && !used[i-1]){
                continue;
            }

            used[i] = true;
            path.add(arr[i]);

            backtrack(arr,used,path,result);

            path.remove(path.size()-1);
            used[i] = false;

        }
    }
}
