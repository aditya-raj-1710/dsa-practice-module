import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequenceSolution sol = new PermutationSequenceSolution();
        int n = 3, k = 5;
        System.out.println(sol.getPermutation(n, k));
    }
}

class PermutationSequenceSolution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) nums.add(i);

        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++) fact[i] = fact[i-1]*i;

        k--;

        StringBuilder ans = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            int index = k/fact[i];
            ans.append(nums.get(index));
            nums.remove(index);
            k %= fact[i];
        }

        return ans.toString();

    }
}

