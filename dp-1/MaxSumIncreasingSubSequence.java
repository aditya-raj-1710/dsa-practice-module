import java.util.Arrays;

public class MaxSumIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        MaxSumIncreasingSubSequenceSolution sol = new MaxSumIncreasingSubSequenceSolution();
        System.out.println(sol.maxSumIncreasingSubsequence(arr,arr.length));
        System.out.println(sol.maxSumIncreasingSubsequence2(arr,arr.length));
    }
}

class MaxSumIncreasingSubSequenceSolution {
    /// Optimal
    public int maxSumIncreasingSubsequence2(int[] arr, int n) {
        int[] dp = arr.clone();

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], arr[i]+dp[j]);
                }
            }
        }

        int max =0;
        for(int curr: dp){
            max = Math.max(max, curr);
        }

        return max;
    }

    /// Recursion + memoization
    public int maxSumIncreasingSubsequence(int[] arr, int n) {
        int[][] dp = new int[n][n+1];

        for(int[] it :dp){
            Arrays.fill(it,-1);
        }
        return func(arr,n,-1,0,dp);
    }

    private int func(int[] arr, int n, int prev, int curr, int[][] dp){
        if(curr == n) return 0;

        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];

        int notTake = func(arr, n, prev, curr+1,dp);

        int take =0;
        if(prev == -1 || arr[prev] < arr[curr])
            take = arr[curr] + func(arr,n,curr,curr+1,dp);

        return dp[curr][prev+1] = Math.max(notTake,take);
    }
}
