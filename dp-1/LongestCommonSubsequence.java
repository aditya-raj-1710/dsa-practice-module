import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        LongestCommonSubsequenceSolution sol = new LongestCommonSubsequenceSolution();

        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs1(s1, s2));
        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs2(s1, s2));
        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs3(s1, s2));
    }
}


class LongestCommonSubsequenceSolution {

    ///Tabulation - space optimization
    public int lcs3( String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i=1;i<=n;i++){
            for(int j=1; j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            System.arraycopy(curr,0,prev,0,m+1);
        }
        return prev[m];
    }

    /// Tabulation
    public int lcs2( String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1; j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    /// Memoization
    public int lcs1(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n][m];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return func(n - 1, m - 1, str1, str2, dp);
    }

    private int func(int i, int j, String str1, String str2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = 1 + func(i - 1, j - 1, str1, str2,dp);
        }

        return dp[i][j] = Math.max(func(i - 1, j, str1, str2,dp), func(i, j - 1, str1, str2,dp));
    }
}
