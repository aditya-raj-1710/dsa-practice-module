import java.util.Arrays;

public class RodCut {
    public static void main(String[] args) {
        RodCutProblemSolution sol = new RodCutProblemSolution();

        int[] prices = {2, 4, 6, 8};

        System.out.println("Max Price:"+ sol.RodCutting(prices, prices.length) );
        System.out.println("Max Price:"+ sol.RodCutting2(prices, prices.length) );
        System.out.println("Max Price:"+ sol.RodCutting3(prices, prices.length) );
        System.out.println("Max Price:"+ sol.RodCutting4(prices, prices.length) );
        System.out.println("Max Price:"+ sol.RodCutting5(prices, prices.length) );
    }
}

class RodCutProblemSolution{
    /// Recursion
    public int RodCutting(int price[], int n) {
        return func(n-1,n,price);
    }

    private int func(int ind,int N,int[] price){
        if(ind ==0) return N * price[ind];

        int notTake = 0 + func(ind-1,N,price);
        int take = Integer.MIN_VALUE;
        int currLength = ind+1;
        if(currLength <=N){
            take = price[ind] + func(ind,N-currLength,price);
        }

        return Math.max(notTake,take);
    }

    /// Recursion + memoization
    public int RodCutting2(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return func(n-1,n,price,dp);
    }

    private int func(int ind,int N,int[] price,int[][] dp){
        if(ind ==0) return N * price[ind];

        if(dp[ind][N] != -1) return dp[ind][N];

        int notTake = 0 + func(ind-1,N,price,dp);
        int take = Integer.MIN_VALUE;
        int currLength = ind+1;
        if(currLength <=N){
            take = price[ind] + func(ind,N-currLength,price,dp);
        }

        return dp[ind][N]=Math.max(notTake,take);
    }

    /// Tabulation
    public int RodCutting3(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for(int N=0;N<=n;N++) dp[0][N] = N * price[0];
        for(int ind=1;ind<n;ind++){
            for(int N=0;N <=n;N++){
                int notTake = 0 + dp[ind-1][N];
                int take = Integer.MIN_VALUE;
                int currLength = ind+1;
                if(currLength <=N){
                    take = price[ind] + dp[ind][N-currLength];
                }

                dp[ind][N]=Math.max(notTake,take);
            }
        }
        return dp[n-1][n];
    }

    /// Tabulation + Space Optimization
    public int RodCutting4(int price[], int n) {
        int[] prev = new int[n+1];
        for(int N=0;N<=n;N++) prev[N] = N * price[0];
        for(int ind=1;ind<n;ind++){
            int[] curr = new int[n+1];
            for(int N=0;N <=n;N++){
                int notTake = 0 + prev[N];
                int take = Integer.MIN_VALUE;
                int currLength = ind+1;
                if(currLength <=N){
                    take = price[ind] + curr[N-currLength];
                }

                curr[N]=Math.max(notTake,take);
            }
            prev=curr;
        }
        return prev[n];
    }

    /// Tabulation + Space Optimization + single array
    public int RodCutting5(int price[], int n) {
        int[] prev = new int[n+1];
        for(int N=0;N<=n;N++) prev[N] = N * price[0];
        for(int ind=1;ind<n;ind++){
            for(int N=0;N <=n;N++){
                int notTake = 0 + prev[N];
                int take = Integer.MIN_VALUE;
                int currLength = ind+1;
                if(currLength <=N){
                    take = price[ind] + prev[N-currLength];
                }

                prev[N]=Math.max(notTake,take);
            }
        }
        return prev[n];
    }
}