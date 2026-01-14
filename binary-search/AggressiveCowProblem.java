import java.util.Arrays;

public class AggressiveCowProblem {
    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 7, 10, 9};
        int k = 4;

        // Create an instance of the Solution class
        AggressiveCowProblemSolution sol = new AggressiveCowProblemSolution();

        int ans = sol.aggressiveCows(nums, k);

        // Output the result
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}

class AggressiveCowProblemSolution {
    public int aggressiveCows(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int low = 1, high = nums[n - 1] - nums[0];  //low can also be optimized here to take min distance between any two consecutive position

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canCowsBePlaced(nums, mid, k)) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }

    private boolean canCowsBePlaced(int[] nums, int distance, int cows) {
        int count = 1;
        int lastPlaced = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - lastPlaced >= distance) {
                lastPlaced = nums[i];
                count++;
            }
            if (count >= cows) {
                return true;
            }
        }
        return false;
    }
}
