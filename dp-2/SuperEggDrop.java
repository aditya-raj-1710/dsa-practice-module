import java.util.Arrays;

public class SuperEggDrop {
    public static void main(String[] args) {
        SuperEggDropSolution sol = new SuperEggDropSolution();
        int n = 2, k = 36; // Example input
        System.out.println(sol.eggDrop1(n, k));
        System.out.println(sol.eggDrop2(n, k));
        System.out.println(sol.eggDrop3(n, k));
    }
}

class SuperEggDropSolution {
    /// Tabulation + space optimization
    public int eggDrop3(int n, int k) {
        int[] dp = new int[n+1];
        int moves=0;

        while(dp[n] <k){
            moves++;
            for(int i=n;i>=1;i--){
                dp[i] = dp[i] + dp[i-1] + 1;
            }
        }
        return moves;
    }

    /// Tabulation
    public int eggDrop2(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            dp[i][0]=0;
        }

        for(int i=1;i<=n;i++){
            dp[i][1]=1;
        }

        for(int i=1;i<=k;i++){
            dp[1][i] = i;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                int low=1, high=j,ans= Integer.MAX_VALUE;

                while(low<=high){
                    int mid = (low+high)/2;

                    int breakCase = dp[i-1][mid-1];
                    int successCase = dp[i][j-mid];

                    int temp = 1+ Math.max(breakCase,successCase);
                    ans = Math.min(ans,temp);

                    if(breakCase < successCase) low = mid+1;
                    else high = mid-1;
                }
                dp[i][j] = ans;
            }
        }

        return dp[n][k];
    }

    /// Recursion + memoization
    public int eggDrop1(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int[] row: dp) Arrays.fill(row,-1);

        return helper(n,k,dp);
    }

    private int helper(int n, int k,int[][] dp){
        if(k==0 || k==1) return k;
        if(n==1) return k;

        if(dp[n][k] !=-1) return dp[n][k];

        int low=1, high=k,ans= Integer.MAX_VALUE;

        while(low<=high){
            int mid = (low+high)/2;

            int breakCase = helper(n-1,mid-1,dp);
            int successCase = helper(n,k-mid,dp);

            int temp = 1+ Math.max(breakCase,successCase);
            ans = Math.min(ans,temp);

            if(breakCase < successCase) low = mid+1;
            else high = mid-1;
        }
        dp[n][k] = ans;
        return ans;
    }
}
