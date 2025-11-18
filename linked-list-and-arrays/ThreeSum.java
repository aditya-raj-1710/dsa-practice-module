import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        ThreeSumSolution solution = new ThreeSumSolution();
        solution.printArray(nums);

        List<List<Integer>> result = solution.threeSumBrute(nums);
        System.out.println(result);

        List<List<Integer>> result1 = solution.threeSumBrute(nums);
        System.out.println(result1);

        List<List<Integer>> result2 = solution.threeSumBrute(nums);
        System.out.println(result2);

    }
}

class ThreeSumSolution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        printArray(nums);

        Set<List<Integer>> triplets = new HashSet<>();

        int n=  nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;;

            int left=i+1;
            int right = n-1;
            //int rem =

            while(left < right){
                int sum = nums[i]+nums[left] + nums[right];

                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    Collections.sort(temp);
                    triplets.add(temp);
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(triplets);
    }

    /// Better Approach
    public List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        int n= nums.length;

        for(int i=0;i<n;i++){
            Set<Integer> hash = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = -(nums[i]+nums[j]);

                if(hash.contains(third)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    Collections.sort(temp);
                    triplets.add(temp);
                }
                hash.add(nums[j]);
            }
        }

        return new ArrayList<>(triplets);
    }

    /// Brute force approach
    public List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        int n= nums.length;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        Collections.sort(temp);
                        triplets.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(triplets);
    }

    public void printArray(int[] nums){
        for(int i : nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}