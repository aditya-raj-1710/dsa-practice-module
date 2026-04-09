public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 7, 1, 2};

        MaxProductSubArraySolution sol = new MaxProductSubArraySolution();

        int ans = sol.maxProduct(nums);
        System.out.println("The product of elements in maximum product subarray is: " + ans);

        ans = sol.maxProductBetter(nums);
        System.out.println("The product of elements in maximum product subarray is: " + ans);

        ans = sol.maxProductBrute(nums);
        System.out.println("The product of elements in maximum product subarray is: " + ans);
    }
}

class MaxProductSubArraySolution{
    /// Optimal
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n= nums.length;
        int prefix=1, suffix=1;

        for(int i=0;i<n;i++){
            if(prefix ==0) prefix=1;
            if(suffix==0) suffix=1;

            prefix *= nums[i];
            suffix *= nums[n-1-i];

            ans = Math.max(ans, Math.max(prefix,suffix));
        }
        return ans;
    }

    /// Better
    public int maxProductBetter(int[] nums) {
        int maxProd = nums[0];
        int n = nums.length;

        for(int i=0;i<n;i++){
            int prod=nums[i]; //first subArray product starting at i index
            for(int j=i+1;j<n;j++){ // subsequent subArray check
                maxProd = Math.max(maxProd,prod);
                prod *= nums[j];
            }
            maxProd = Math.max(maxProd,prod); // check for subArray ending at nums[i]
        }
        return maxProd;
    }

    /// Brute Force
    public int maxProductBrute(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int prod=1;
                for(int k=i;k <=j;k++){
                    prod *= nums[k];
                }
                maxProd = Math.max(maxProd,prod);
            }
        }
        return maxProd;
    }
}