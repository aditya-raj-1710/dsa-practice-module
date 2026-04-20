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
    }
}

class MinimumPathSumSolution {

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
}