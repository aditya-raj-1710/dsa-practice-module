import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        MatrixMultiplicationSolution sol = new MatrixMultiplicationSolution();

        System.out.println("The minimum number of operations is " + sol.matrixMultiplication(arr));
    }
}

class MatrixMultiplicationSolution {

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
