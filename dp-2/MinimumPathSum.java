import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };

        MinimumPathSumSolution sol = new MinimumPathSumSolution();

        System.out.println(sol.minFallingPathSum(matrix));
        System.out.println(sol.minFallingPathSum2(matrix));
        System.out.println(sol.minFallingPathSum3(matrix));
    }
}

class MinimumPathSumSolution {
    /// Space Optimization
    public int minFallingPathSum3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int[] curr = new int[m];
        for (int j = 0; j < m; j++) prev[j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];

                int leftD = matrix[i][j];
                if (j - 1 >= 0) leftD += prev[j - 1];
                else leftD = Integer.MAX_VALUE;
                int rightD = matrix[i][j];
                if (j + 1 < m) rightD += prev[j + 1];
                else rightD = Integer.MAX_VALUE;

                curr[j] = Math.min(up, Math.min(leftD, rightD));
            }
            System.arraycopy(curr,0,prev,0,m);
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }

        return mini;
    }

    ///  Tabulation
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) dp[0][j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftD = matrix[i][j];
                if (j - 1 >= 0) leftD += dp[i - 1][j - 1];
                else leftD = Integer.MAX_VALUE;
                int rightD = matrix[i][j];
                if (j + 1 < m) rightD += dp[i - 1][j + 1];
                else rightD = Integer.MAX_VALUE;

                dp[i][j] = Math.min(up, Math.min(leftD, rightD));
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }

    /// Recursion + memoization
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] it:dp) Arrays.fill(it, -1);

        int mini = Integer.MAX_VALUE;

        for(int j=0;j<m;j++){
            int ans = func(n-1,j,m,matrix,dp);
            mini = Math.min(mini,ans);
        }

        return mini;

    }
    private int func(int i,int j, int m, int[][] matrix, int[][] dp){
        if(j <0 || j>= m) return (int) 1e9;
        if(i==0) return matrix[0][j];

        if(dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + func(i-1,j,m,matrix,dp);
        int leftD = matrix[i][j] + func(i-1,j-1,m,matrix,dp);
        int rightD = matrix[i][j] + func(i-1,j+1,m,matrix,dp);

        return dp[i][j]=Math.min(up, Math.min(leftD,rightD));
    }

    /// Leetcode Minimum Path Sum solution
    public int minPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int[] curr = new int[m];
        /// Base case is to have cumulative sum as valid path here is all right movement.
        prev[0] = matrix[0][0];
        for (int j = 1; j < m; j++)
            prev[j] = prev[j - 1] + matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];

                int leftD = matrix[i][j];
                if (j - 1 >= 0)
                    leftD += curr[j - 1]; // since it's right ONLY movement instead of diagonal
                else
                    leftD = Integer.MAX_VALUE;
                curr[j] = Math.min(up, leftD);
            }
            System.arraycopy(curr, 0, prev, 0, m);
        }

        /// returning for m-1 as target is to reach bottom right corner from top left corner
        return prev[m - 1];

    }
}