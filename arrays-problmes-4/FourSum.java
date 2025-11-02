import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;

        FourSumSolution solution = new FourSumSolution();
        System.out.println("quadruplets are: "+ solution.fourSum(nums,target));
    }
}

class FourSumSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList() {
        };

        int n = nums.length;

        if (nums == null || n < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];

                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        result.add(temp);

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }

            }
        }

        return result;
    }
}
