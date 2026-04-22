import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 4;

        SubsetSumSolution sol = new SubsetSumSolution();

        if (sol.isSubsetSum(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        if (sol.isSubsetSum2(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        if (sol.isSubsetSum3(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}

class SubsetSumSolution {
    /// Tabulation - Space optimization
    public boolean isSubsetSum3(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev= new boolean[target+1];
        prev[0] = true;

        if(arr[0] <= target) prev[arr[0]] = true;

        for(int ind=1;ind<n;ind++){
            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            for(int k=1;k<=target;k++){
                boolean notTake = prev[k];
                boolean take = false;
                if(arr[ind] <= k){
                    take = prev[k-arr[ind]];
                }
                curr[k] = take || notTake;
            }
            prev=curr;
        }
        return prev[target];
    }

    /// Tabulation
    public boolean isSubsetSum2(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++)dp[i][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        for(int ind=1;ind<n;ind++){
            for(int k=1;k<=target;k++){
                boolean notTake = dp[ind-1][k];
                boolean take = false;
                if(arr[ind] <= k){
                    take = dp[ind-1][k-arr[ind]];
                }
                dp[ind][k] = take || notTake;
            }
        }
        return dp[n-1][target];
    }

    /// Recursion + Memoization
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int[] row: dp) Arrays.fill(row,-1);
        return func(n-1,target,arr,dp);
    }

    private boolean func(int ind, int target, int[] arr, int[][] dp){
        if(target ==0) return true;
        if(ind==0) return arr[ind] == target;

        if(dp[ind][target] != -1) return dp[ind][target]== 1;

        boolean notTake = func(ind-1,target,arr,dp);
        boolean take = false;
        if(arr[ind] <= target){
            take = func(ind-1,target-arr[ind],arr,dp);
        }
        dp[ind][target] = ((take || notTake) ? 1: 0);
        return dp[ind][target]==1;
    }
}

