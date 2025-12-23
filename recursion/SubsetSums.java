import java.util.Arrays;

public class SubsetSums {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 4;

        SubsetSumsSolution solution = new SubsetSumsSolution();

        System.out.println("Subset exists? "+ solution.isSubsetSum(arr,target));
        System.out.println("Subset exists? "+ solution.isSubsetSumBrute(arr,target));
    }
}

class SubsetSumsSolution {
    public boolean isSubsetSum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return func(arr, arr.length-1,target,dp);
    }

    private boolean func(int[] arr, int index, int target, int[][] dp){
        if(target ==0){
            return true;
        }

        if(index == 0){
            return arr[index] == target;
        }

        if(dp[index][target] != -1){
            return dp[index][target] ==0 ? false: true;
        }

        boolean notTaken = func(arr, index-1,target,dp);
        boolean taken =false;
        if(arr[index] <= target){
            taken = func(arr,index-1, target-arr[index],dp);
        }

        dp[index][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }


    /// Brute Force solution
    public boolean isSubsetSumBrute(int[] arr, int target) {
        return func(arr, arr.length-1,target);
    }

    private boolean func(int[] arr, int index, int target){
        if(target ==0){
            return true;
        }

        if(index == 0){
            return arr[index] == target;
        }

        boolean notTaken = func(arr, index-1,target);
        boolean taken =false;
        if(arr[index] <= target){
            taken = func(arr,index-1, target-arr[index]);
        }

        return notTaken || taken;
    }
}
