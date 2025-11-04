import java.util.HashMap;

public class LongestSubArraySum {
    public static void main(String[] args) {
        LongestSubArraySumSolution solution = new LongestSubArraySumSolution();

        int[] nums = {10, 5, 2, 7, 1, 9};

        System.out.println(solution.longestSubarray(nums,15));
        System.out.println(solution.subarraySum(nums,15));
    }
}

class LongestSubArraySumSolution {

    /// Brute force logic but will result in TLE
    public int longestSubarrayBrute(int[] nums, int targetSum) {
        int n = nums.length;
        int maxLength =0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int currentSum =0;

                for(int k=i;k<=j;k++){
                    currentSum +=nums[k];
                }


                if(currentSum == targetSum){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }

    /// Prefix sum usage
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int sum =0;
        int maxLen =0;

        for(int i=0;i<n;i++){
            sum += nums[i];

            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }

            int rem = sum-k;

            if(prefixSum.containsKey(rem)){
                int len = i- prefixSum.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum,i);
            }

        }

        return maxLen;
    }

    /// Finding count of sub arrays leading upto the sum
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int sum =0;
        int count =0;
        prefixSum.put(0,1);

        for(int i=0;i<n;i++){
            sum += nums[i];
            if(prefixSum.containsKey(sum-k)){
                count += prefixSum.get(sum-k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum,0)+1);

        }

        return count;
    }
}