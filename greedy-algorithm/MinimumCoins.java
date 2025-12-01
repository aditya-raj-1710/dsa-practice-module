import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 7;

        MinimumCoinsSolution solution = new MinimumCoinsSolution();

        System.out.println(solution.MinimumCoins(coins,amount));
    }
}

class MinimumCoinsSolution {
    public int MinimumCoins(int[] coins, int amount) {
        int n= coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        int ans = func(coins,n-1,amount,dp);

        if(ans >= (int)1e6)
            return -1;

        return ans;
    }

    private int func(int[] arr, int ind, int T,int[][] dp){
        if(ind == 0){
            if(T % arr[0] == 0){
                return T/arr[0];
            }else{
                return (int)1e6;
            }
        }

        if(dp[ind][T] !=-1){
            return dp[ind][T];
        }

        int notTaken = func(arr, ind-1,T,dp);
        int taken = (int)1e6;

        if(arr[ind] <=T){
            taken = 1+ func(arr,ind, T- arr[ind],dp);
        }

        return dp[ind][T] = Math.min(taken,notTaken);
    }
}


