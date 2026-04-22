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
    }
}

class SubsetSumSolution {

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

