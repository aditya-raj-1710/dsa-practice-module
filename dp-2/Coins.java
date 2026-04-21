import java.util.Arrays;

public class Coins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        int N = coins.length;

        CoinsSolution sol = new CoinsSolution();

        System.out.println("The total number of ways is " + sol.count(coins, N, amount));
        System.out.println("The total number of ways is " + sol.count1(coins, N, amount));
    }
}

class CoinsSolution {
    private int MOD = (int)1e9+7;

    /// Tabulation - space optimization
    public int count1(int[] coins, int N, int amount) {
        long[]prev = new long[amount+1];
        for(int j=0;j<=amount;j++) prev[j] = (j%coins[0]==0)? 1:0;

        for(int ind=1;ind<N;ind++){
            long[] curr = new long[amount+1];
            for(int T=0;T<=amount;T++){
                int notTaken = (int)prev[T];
                int taken =0;
                if(coins[ind] <= T){
                    taken = (int)curr[T-coins[ind]];
                }

                curr[T]=(notTaken + taken)%MOD;
            }
            prev=curr;
        }
        return (int)prev[amount];
    }

    /// Recursion + memoization
    public int count(int[] coins, int N, int amount) {
        long[][] dp = new long[N][amount+1];
        for(long[] row: dp) Arrays.fill(row,-1);
        return func(coins,N-1,amount,dp);
    }
    private int func(int[] arr, int ind, int T,long[][] dp){
        if(ind == 0){
            return (T%arr[ind] == 0) ? 1: 0;
        }
        if(dp[ind][T] != -1) return (int)dp[ind][T];

        int notTaken = func(arr,ind-1,T,dp);
        int taken =0;
        if(arr[ind] <= T){
            taken = func(arr,ind,T-arr[ind],dp);
        }

        return (int)(dp[ind][T]=(notTaken + taken)%MOD);
    }
}

