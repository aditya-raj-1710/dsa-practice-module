public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};

        // Create an object of the Solution class.
        SingleElementInSortedArraySolution sol = new SingleElementInSortedArraySolution();

        int ans = sol.singleNonDuplicate(nums);
        System.out.println("The single element is: " + ans);

        ans = sol.singleNonDuplicateOptimalBrute(nums);
        System.out.println("The single element is: " + ans);

        ans = sol.singleNonDuplicateBrute(nums);
        System.out.println("The single element is: " + ans);
    }
}

class SingleElementInSortedArraySolution {

    /// Binary Search Approach
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }

        int low=1, high = n-2;
        while(low <=high){
            int mid = low +(high-low)/2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            if((mid%2 == 1 && nums[mid] == nums[mid-1])
                    || mid%2 == 0 && nums[mid]== nums[mid+1]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }


    /// Optimal Brute
    public int singleNonDuplicateOptimalBrute(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }

        int ans =0;

        for(int i=0;i<n;i++){
            ans ^= nums[i];
        }
        return ans;
    }

    /// Brute Force Approach
    public int singleNonDuplicateBrute(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }

        for(int i=0;i<n;i++){
            if(i==0 && nums[i] != nums[i+1]){
                return nums[i];
            }else if(i== n-1 && nums[i] != nums[i-1]){
                return nums[i];
            }else if(nums[i] != nums[i+1] && nums[i] != nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}