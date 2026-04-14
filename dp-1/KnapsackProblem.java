import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        KnapsackProblemSolution sol = new KnapsackProblemSolution();

        System.out.println("The Maximum value of items is " + sol.knapsack01(wt, val, n, W));
    }
}

class KnapsackProblemSolution {

    /// Recursion + Memoization
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];

        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return func(wt,val, n-1, W,dp);
    }

    private int func(int[] wt, int[] val, int ind, int W, int[][] dp){
        if(ind <0 ||W ==0){
            return 0;
        }

        if(dp[ind][W] !=-1){
            return dp[ind][W];
        }

        int notTaken = func(wt, val, ind-1,W,dp);
        int taken =0;

        if(wt[ind] <= W){
            taken = val[ind] + func(wt, val, ind-1,W-wt[ind],dp);
        }

        return dp[ind][W]=Math.max(notTaken,taken);

    }
}

