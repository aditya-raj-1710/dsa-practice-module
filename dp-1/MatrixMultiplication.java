import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        MatrixMultiplicationSolution sol = new MatrixMultiplicationSolution();

        System.out.println("The minimum number of operations is " + sol.matrixMultiplication(arr));
        System.out.println("The minimum number of operations is " + sol.matrixMultiplication2(arr));
    }
}

class MatrixMultiplicationSolution {

    /// Tabulation
    public int matrixMultiplication2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] it: dp) Arrays.fill(it, Integer.MAX_VALUE);

        for(int i=1;i<n;i++) dp[i][i] = 0;

        for(int length = 2; length<n;length++){
            for(int i=1;i <= n-length;i++){
                int j = i+length-1;
                for(int k=i;k<j;k++){
                    int steps = nums[i-1]*nums[k]*nums[j]
                            +dp[i][k] + dp[k+1][j];
                    if(steps < dp[i][j]) dp[i][j] = steps;
                }
            }
        }
        return dp[1][n-1];
    }


    /// Recursion + memoization
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return func(1,n-1,nums,dp);
    }
    private int func(int i,int j,int[] nums, int[][] dp){
        if(i==j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int steps = nums[i-1]*nums[k]*nums[j]
                    +func(i,k,nums,dp) + func(k+1,j,nums,dp);
            if(steps < min) min = steps;
        }
        return dp[i][j] = min;
    }
}
