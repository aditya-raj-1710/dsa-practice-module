import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        EditDistanceSolution sol = new EditDistanceSolution();

        System.out.println("The minimum number of operations required is: " + sol.editDistance(s1, s2));
        System.out.println("The minimum number of operations required is: " + sol.editDistance2(s1, s2));
        System.out.println("The minimum number of operations required is: " + sol.editDistance3(s1, s2));
    }
}

class EditDistanceSolution {

    /// Space optimization
    public int editDistance3(String start, String target) {
        int n= start.length();
        int m= target.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i=0;i<=m;i++){
            prev[i] = i;
        }

        for(int i=1;i<=n;i++){
            curr[0] = i;
            for(int j=1;j<=m;j++){
                if(start.charAt(i-1) == target.charAt(j-1))
                    curr[j] = prev[j-1];
                else{
                    curr[j] = 1+Math.min( prev[j],
                            Math.min(curr[j-1],prev[j-1]));
                }
            }
            System.arraycopy(curr,0,prev,0,m+1);
        }
        return prev[m];
    }

    /// Tabulation
    public int editDistance2(String start, String target) {
        int n= start.length();
        int m= target.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }

        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(start.charAt(i-1) == target.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = 1+Math.min( dp[i-1][j],
                            Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }

    /// Recursion + memoization
    public int editDistance(String start, String target) {
        int n= start.length();
        int m= target.length();

        int[][] dp = new int[n][m];

        for(int[] it: dp){
            Arrays.fill(it, -1);
        }
        return func(n-1,m-1,start,target,dp);

    }

    private int func(int i,int j, String start, String target,int[][] dp){
        if(i <0) return j+1;
        if(j <0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];

        if(start.charAt(i) == target.charAt(j))
            return dp[i][j] = func(i-1,j-1,start,target,dp);

        return dp[i][j] = 1+Math.min( func(i-1,j,start,target,dp),
                Math.min(func(i,j-1,start,target,dp),
                        func(i-1,j-1,start,target,dp)));
    }
}

