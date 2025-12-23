public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        // Create an instance of the Solution class
        SearchInSortedRotatedArraySolution sol = new SearchInSortedRotatedArraySolution();

        // Function call to search for the target element
        int result = sol.search(nums, target);

        if (result == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + result);

        result = sol.searchLinear(nums, target);

        if (result == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + result);
    }
}

class SearchInSortedRotatedArraySolution {

    /// Binary Search Approach
    public int search(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == k) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= k && k <= nums[mid]) {
                    high = mid - 1;
                }else{
                    low = mid+1;
                }
            } else {
                if (nums[mid] <= k && k <= nums[high]) {
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }

    /// Linear Approach
    public int searchLinear(int[] nums, int k) {
        int ans=-1;

        for(int i=0; i<nums.length;i++){
            if(nums[i] == k){
                ans=i;
            }
        }
        return ans;
    }
}

