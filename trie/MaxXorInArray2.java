import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxXorInArray2 {
    public static void main(String[] args) {
        MaxXorInArray2Solution sol = new MaxXorInArray2Solution();

        int[] nums = {0, 1, 2, 3, 4};

        int[][] queries = {{3, 1}, {1, 3}, {5, 6}};

        List<Integer> result = sol.maximizeXor(nums, queries);

        System.out.println("Result of Max XOR Queries:");
        for (int i = 0; i < result.size(); ++i) {
            System.out.println("Query " + (i + 1) + ": " + result.get(i));
        }
    }
}

class MaxXorInArray2Solution {
    public List<Integer> maximizeXor(int[] nums, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            ans.add(i,-1);
        }

        List<int[]> offlineQueries = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<queries.length;i++){
            offlineQueries.add(new int[]{queries[i][1],queries[i][0],i});
        }

        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        int i=0;
        TrieXor trie = new TrieXor();

        for(int[] query: offlineQueries){
            while(i< nums.length && nums[i] <= query[0]){
                trie.insert(nums[i]);
                i++;
            }

            if(i !=0){
                ans.set(query[2], trie.getMax(query[1]));
            }
        }
        return ans;
    }
}
