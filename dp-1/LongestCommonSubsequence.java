import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        LongestCommonSubsequenceSolution sol = new LongestCommonSubsequenceSolution();

        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs(s1, s2));
    }
}


class LongestCommonSubsequenceSolution {
    public int lcs(String str1, String str2) {
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
