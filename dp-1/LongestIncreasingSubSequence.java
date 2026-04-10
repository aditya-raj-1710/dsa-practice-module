import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        LongestIncreasingSubSequenceSolution sol = new LongestIncreasingSubSequenceSolution();
        int lengthOfLIS = sol.LISBrute(nums);

        System.out.println("The length of the LIS for the given array is: " + lengthOfLIS);

        lengthOfLIS = sol.LISBetter(nums);

        System.out.println("The length of the LIS for the given array is: " + lengthOfLIS);

        lengthOfLIS = sol.LIS(nums);

        System.out.println("The length of the LIS for the given array is: " + lengthOfLIS);
    }
}

class LongestIncreasingSubSequenceSolution {
    public int LIS(int[] nums) {
        int n = nums.length;

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1))
                temp.add(nums[i]);

            else {
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                temp.set(ind, nums[i]);
            }
        }
        return temp.size();
    }

    public int LISBetter(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] it: dp){
            Arrays.fill(it,-1);
        }
        return func(0,-1,nums,dp);
    }

    private int func(int i, int prev, int[] nums,int[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1] !=-1){
            return dp[i][prev+1];
        }

        int notTake = func(i+1, prev,nums,dp);
        int take=0;
        if(prev==-1  || nums[i] > nums[prev]){
            take = func(i+1, i, nums,dp)+1;
        }

        return dp[i][prev+1]=Math.max(take,notTake);
    }

    public int LISBrute(int[] nums) {
        return func(0,-1,nums);
    }

    private int func(int i, int prev, int[] nums){
        if(i==nums.length-1){
            if(prev == -1 || nums[prev] < nums[i]) return 1;
            return 0;
        }

        int notTake = func(i+1, prev,nums);
        int take=0;
        if(prev==-1  || nums[i] > nums[prev]){
            take = func(i+1, i, nums)+1;
        }

        return Math.max(take,notTake);
    }
}

